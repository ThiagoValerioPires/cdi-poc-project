package com.argus.cdi.web.cdi.context;

import java.util.Map;

import javax.enterprise.context.spi.Contextual;

public interface ConversationBeanStorage {	
	
	Map<Contextual<?>, Object> getComponentInstanceMap();

}
