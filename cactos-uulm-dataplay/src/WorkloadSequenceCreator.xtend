

import tools.descartes.dlim.Sequence
import tools.descartes.dlim.DlimFactory
import tools.descartes.dlim.TimeDependentFunctionContainer
import tools.descartes.dlim.Function
import tools.descartes.dlim.Operator
import java.util.Collections
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.List
import java.util.LinkedList
import org.eclipse.emf.common.util.EList

class WorkloadSequenceCreator {
	/** Descartes Load Intensity Model Factory */
	DlimFactory df = DlimFactory.eINSTANCE;
	
	double MAX = -3.0
	double MIN = 2.0
	
	def Sequence createPlayGenSequence() {
		return df.createSequence => [
			terminateAfterLoops = 1;
			sequenceFunctionContainers += createSegment(28,10)
			sequenceFunctionContainers += createSegment(25,10)
			sequenceFunctionContainers += createSegment(28,10)
			sequenceFunctionContainers += createSegment(22,10)
			sequenceFunctionContainers += createSegment(28,10)
			sequenceFunctionContainers += createSegment(20,10)
			sequenceFunctionContainers += createSegment(27,10)
			sequenceFunctionContainers += createSegment(35,10)
			sequenceFunctionContainers += createSegment(40,10)
			sequenceFunctionContainers += createSegment(35,10)
			sequenceFunctionContainers += createSegment(38,10)
			sequenceFunctionContainers += createSegment(54,10)
			sequenceFunctionContainers += createSegment(80,4*60)
			sequenceFunctionContainers += createSegment(100,4*60)
			sequenceFunctionContainers += createSegment(35,4*60)
			sequenceFunctionContainers += createSegment(38,4*60)
			sequenceFunctionContainers += createSegment(54,4*60)
			addReversedCopy(sequenceFunctionContainers)
			sequenceFunctionContainers.forEach[addNoise]
			for(var i = 0; i < 3; i++) {
				var tempCopy = new LinkedList(EcoreUtil.copyAll(sequenceFunctionContainers))
				tempCopy.forEach[addNoise]
				sequenceFunctionContainers += tempCopy
			}
			addReversedCopy(sequenceFunctionContainers)
		]
	}
	
	def addReversedCopy(EList<TimeDependentFunctionContainer> sequenceFunctionContainers) {
			var reversed = new LinkedList(EcoreUtil.copyAll(sequenceFunctionContainers))
			Collections.reverse(reversed)
			sequenceFunctionContainers += reversed
	}
	
	def addNoise(TimeDependentFunctionContainer in) {
		in.function.combine += df.createCombinator => [
			operator = Operator.ADD
			function = df.createUniformNoise => [
				max = MAX
				min = MIN
			]
		]
		return in
	}
	
	def TimeDependentFunctionContainer createSegment(int intensity, double length) {
		return df.createTimeDependentFunctionContainer => [
			duration = length
			function = df.createConstant => [
				constant = intensity
			]
		]
	}
	
}