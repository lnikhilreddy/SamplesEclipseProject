package org.nikhil.SampleCode.core.sightly.bindings;

import org.apache.sling.api.resource.ResourceResolver;

import org.mozilla.javascript.BaseFunction; 
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;  



public class MyCustomFunctionUsingBaseFunction extends BaseFunction  {  
	
	public MyCustomFunctionUsingBaseFunction(ResourceResolver rr) {
		
	}
	 
	@Override
    public String call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
        return System.getProperty("java.runtime.version");
    }

}
