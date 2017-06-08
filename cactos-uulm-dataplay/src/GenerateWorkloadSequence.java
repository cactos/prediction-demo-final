import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import eu.cactosfp7.infrastructuremodels.logicaldc.core.util.CoreResourceFactoryImpl;
import tools.descartes.dlim.Sequence;
import tools.descartes.dlim.impl.DlimFactoryImpl;

public class GenerateWorkloadSequence {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(GenerateWorkloadSequence.class.getCanonicalName());
	
	/**Creates model files in the project root directory.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// Register EMF factories
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("logical", new CoreResourceFactoryImpl());
	    
	    final String modelName = "workload";
		ResourceSet resourceSet = new ResourceSetImpl();
	    Resource resource = resourceSet.createResource(URI.createURI(modelName + ".logical"));
	    WorkloadSequenceCreator generator = new WorkloadSequenceCreator();
	    Sequence generatedSequence = generator.createPlayGenSequence();
		resource.getContents().add(generatedSequence);
		try {
			resource.save(null);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Could not store resource. ", e);
		}
	}
}
