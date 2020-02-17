package com.argus.cdi.web.cdi.context;


import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;


public class ConversationContextExtension implements Extension {
	
	public void addScope(@Observes final BeforeBeanDiscovery event){
		event.addScope(ConversationScoped.class, true, true);
	}

	public void registerContext(@Observes final AfterBeanDiscovery event){
		event.addContext(new ConversationContext());
	}
	
}
