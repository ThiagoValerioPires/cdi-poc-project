package com.argus.cdi.web.cdi.context;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;


public class ConversationContext implements Context{
	
	@Override
	public <T> T get(final Contextual<T> component){
	
		@SuppressWarnings("unchecked")
		T instance = (T) ConversationBeanStorageFactory.getInstance().getComponentInstanceMap().get(component);
		return instance;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(final Contextual<T> component, final CreationalContext<T> creationalContext) {
		
		assertActive();

		T instance = get(component);
		if (instance == null) {
			
			if (creationalContext != null){
				
				Map<Contextual<?>, Object> componentInstanceMap = ConversationBeanStorageFactory.getInstance().getComponentInstanceMap();

				synchronized (componentInstanceMap){					
					instance = (T) componentInstanceMap.get(component);
					if (instance == null){
						
						instance = component.create(creationalContext);
						if (instance != null){							
							componentInstanceMap.put(component, instance);							
						}
					}
				}
			}
		}

		return instance;
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return ConversationScoped.class;
	}


	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException("CDI context with scope annotation @MaxConversationScoped is not active with respect to the current thread");
		}
	}


	@Override
	public boolean isActive() {		
		return ConversationBeanStorageFactory.getInstance().getComponentInstanceMap() != null;
	}


}