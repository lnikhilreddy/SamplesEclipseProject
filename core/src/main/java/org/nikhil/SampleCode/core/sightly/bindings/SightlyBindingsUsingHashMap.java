package org.nikhil.SampleCode.core.sightly.bindings;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import java.util.HashMap;
import java.util.Map;

@Component
@Service(Map.class)
@Property(name = "javax.script.name", value = "any")
public class SightlyBindingsUsingHashMap extends HashMap<String, Object> {

    public SightlyBindingsUsingHashMap() {
        put("javaNikhilsVersion", System.getProperty("java.runtime.version"));
        put("FunctionCallInHashmap", CheckFunctionCallInHashmap());
    }
    
    public String CheckFunctionCallInHashmap() {
    	return new String("FunctionCallInHashmapValue"); 
    }
} 
