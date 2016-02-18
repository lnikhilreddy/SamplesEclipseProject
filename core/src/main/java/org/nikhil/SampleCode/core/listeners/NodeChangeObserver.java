package org.nikhil.SampleCode.core.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

@Service
@Component(immediate=true,metatype=true)
@Properties({
	@org.apache.felix.scr.annotations.Property(name="service.description", value="Sample Event Handler Example"),
	@org.apache.felix.scr.annotations.Property(name="service.vendor", value="Adobe"),
	@org.apache.felix.scr.annotations.Property(name="observer.node.path", value="/content")
})

public class NodeChangeObserver implements EventListener{
	
private Logger log = LoggerFactory.getLogger(getClass());
    
    @Reference
    private SlingRepository repository;
    
    private Session session;
    private ObservationManager observationManager;
    
   
	
    protected void activate(ComponentContext context)  throws Exception {
        session = repository.loginAdministrative(null);
        log.info("############ Node Change Observer Activateds ######");
       // Listen for changes to our orders
        if (repository.getDescriptor(Repository.OPTION_OBSERVATION_SUPPORTED).equals("true")) {
            observationManager = session.getWorkspace().getObservationManager();
            final String[] types 	= { "nt:unstructured","sling:Folder" };
            String path 			= (String) context.getProperties().get("observer.node.path");
            path					= (path == null) ? "/content" : path;
            observationManager.addEventListener(this, Event.NODE_ADDED, path, true, null, types, false);
            log.error("Observing property changes to {} nodes under {}", Arrays.asList(types), path);
        }
        
    }

    protected void deactivate(ComponentContext componentContext) throws RepositoryException {
        
        if(observationManager != null) {
            observationManager.removeEventListener(this);
        }
        if (session != null) {
            session.logout();
            session = null;
            
            
        }
    }
	

	public void onEvent(EventIterator itr) {
		log.error("Found event !!!!!!");
	}

	

}
