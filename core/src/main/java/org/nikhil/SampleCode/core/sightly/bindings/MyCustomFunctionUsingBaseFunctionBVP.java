package org.nikhil.SampleCode.core.sightly.bindings;

import javax.script.Bindings;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.scripting.api.BindingsValuesProvider;
import org.slf4j.Logger;

@Component
@Service
@Property(name = "javax.script.name", value = "sightly")
public class MyCustomFunctionUsingBaseFunctionBVP implements BindingsValuesProvider {

	@Override
	public void addBindings(Bindings bindings) {
		// TODO Auto-generated method stub
		SlingHttpServletRequest request = (SlingHttpServletRequest) bindings.get(SlingBindings.REQUEST);
        if (request != null) { 
            bindings.put("bindingCustomFunction", new MyCustomFunctionUsingBaseFunction(request.getResourceResolver()));
        }
	}

}
