"use strict";
use(function () {
    var info = {};    
    // Does not work
    info.helloWorld 		= sling.getService(Packages.org.nikhil.SampleCode.core.models.HelloWorldModel);
    
    // Does not work
    info.hw					= org.nikhil.SampleCode.core.models.HelloWorldModel;
    
    // Works
    info.ss					= sling.getService(Packages.org.nikhil.SampleCode.core.service.SampleService);
    
    // Works
    info.ssimpl				= org.nikhil.SampleCode.core.service.SampleServiceImpl;
    //info.str				= org.nikhil.SampleCode.core.service.SampleServiceImpl.getHello();
    
    info.bindingHashMapVariable = javaNikhilsVersion;
    
    info.bindingCustomFunction 			= bindingCustomFunction;
    
    return info;
});