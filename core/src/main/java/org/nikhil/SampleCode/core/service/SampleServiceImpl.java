package org.nikhil.SampleCode.core.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import com.adobe.cq.sightly.WCMUse;

@Component(
        label = "ACS AEM Samples - Basic OSGi Service",
        description = "Sample implementation of an OSGi service",
        metatype = true,
        configurationFactory = true)
@Properties({
    @Property(
        label = "Service Name",
        name = SampleService.PROP_NAME,
        description = "This is an example property which is used to uniquely identify the service impl by name.",
        value = "my-sample"
    )
})
@Service
public class SampleServiceImpl extends WCMUse implements SampleService  {
	
	 @Override
    public void activate() throws Exception {
       
    }
	 
	 @Override
	 public String getHello() { 
	     return "Hello World!";
	 }
}