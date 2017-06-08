#library(devEMF)
baseDir <- "C:/Users/stier/git/prediction-demo-final/cactos-uulm-consolidation-1/"
setwd(baseDir)
measuredDir <- paste(baseDir, "powermgmt-measured-csv/", sep = "")
measuredFilePattern <- "^(computenode).*(Power_Consumption_Tuple)"

simulationDir <- paste(baseDir, "powermgmt-sim-csv/", sep = "")
simulationFilePattern <- "^(computenode)((0[^2])|(1[^6])).*(Power_Consumption_Tuple)"

windowSizeMeasured <- 20
plotResolution <- 50
min.y <- 400

# rollmean_r from http://stackoverflow.com/questions/20134823/r-faster-way-to-calculate-rolling-statistics-over-a-variable-interval
rollmean_r = function(x,y,xout,width) {
  out = numeric(length(xout))
  for( i in seq_along(xout) ) {
    window = x >= (xout[i]-width) & x <= (xout[i]+width)
    if(length(y[window]) == 0 || is.na(y[window])) {
      out[i] = 0
    } else {
      out[i] = .Internal(mean( y[window] ))
    }
  }
  return(out)
}

rollmean_of_df <- function(xy) {
  force(xy)
  return (function(x) {
    return (rollmean_r(x = xy[[1]], y = xy[[2]], xout = c(x), width = windowSizeMeasured))
  })
}

meas.filenames <- list.files(path = measuredDir, pattern = measuredFilePattern)
sim.filenames <- list.files(path = simulationDir, pattern = simulationFilePattern)

max.x <- 0
max.x1 <- 0
max.x2 <- 0
max.y <- 0

sim.functions <- c()
for (i in sim.filenames) {
  df <- read.csv(file=paste(simulationDir, i, sep = ""))
  df <- subset(df, df$Point.in.Time.s. >= 36100)
  df$Point.in.Time.s. <- df$Point.in.Time.s. - 36100
  apfun <- approxfun(x = df[[1]], y = df[[2]], rule = 2)
  sim.functions <- c(apfun, sim.functions)
  max.x1 <- max(max.x1, max(df[[1]]))
}
sim.func <- Vectorize(function(x) sum(sapply(sim.functions, do.call, args=list(x))))
max.y <- max(sim.func(seq(0, max.x1, 1)))

meas.functions <- c()
for (i in meas.filenames) {
  dm <- read.csv(file=paste(measuredDir, i, sep = ""))
  apfun <- rollmean_of_df(dm)
  meas.functions <- c(apfun, meas.functions)
  max.x2 <- max(max.x2, max(dm[[1]]))
}

max.x <- min(max.x1, max.x2)
meas.func <- Vectorize(function(x) sum(sapply(meas.functions, do.call, args=list(x))))

max.y <- max(max.y, max(meas.func(seq(0, max.x, 1))))

energy.sim <- (integrate(sim.func, 0.0, max.x, subdivisions = 10000))$value
energy.meas <- (integrate(meas.func, 0.0, max.x, subdivisions = 10000))$value

colors <- rainbow(2)

#emf(file="powerconsumption_datacentre_os2-b.emf", height = 8, width = 12, family = "Calibri", pointsize = 20)
png(filename = "powerconsumption_datacentre_uulm_powermgmt_comparison_measured.png",
    width = 1280, height = 720, units = "px", pointsize = 12,
    bg = "white")

par(mar=c(5,7,4,2))

#pdf("powerconsumption_datacentre_uulm_powermgmt2.pdf", height = 4, width = 7)
plot(df, type="n", xlim=c(0, max.x), ylim=c(0, max.y), xlab="Experiment time (s)", ylab="Power Consumption", cex.lab=2, cex.axis=2, cex.main=2, cex.sub=2)

lines(y=sapply(seq(0, max.x, plotResolution), meas.func), x=seq(0, max.x, plotResolution), lwd=2.5, type="l", col=colors[2],cex=1.5)
lines(y=sapply(seq(0, max.x, plotResolution), sim.func), x=seq(0, max.x, plotResolution), lwd=2,5, type="l", col=colors[1],cex=1.5)  
legend(max.x - 26000, 150, c("Predicted with Power Mgmt.", "Measured with Power Mgmt."), lty=c(1,1), lwd=c(2.5,2.5), col=colors,cex=1.5)
dev.off()