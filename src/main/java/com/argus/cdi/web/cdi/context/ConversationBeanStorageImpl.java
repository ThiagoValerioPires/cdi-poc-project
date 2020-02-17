package com.argus.cdi.web.cdi.context;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.spi.Contextual;
import javax.servlet.http.HttpSession;


public class ConversationBeanStorageImpl implements ConversationBeanStorage, ConversationBeanStorageConfig, Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private final static String COMPONENT_MAP_NAME =  "componentInstanceMap_";
	private final static String MAX_CONVERSATION_BEAN_MAP =  "maxConversationBeanMap";
	
	
	private String conversationId;	
	private HttpSession session;
	

	
	public Map<Contextual<?>, Object> getComponentInstanceMap() {
				
		Map<String, Map<Contextual<?>, Object>> maxConversationBeanMap = getMaxConversationBeanMap();
		Map<Contextual<?>, Object> componentInstanceMap =  maxConversationBeanMap.get(COMPONENT_MAP_NAME+conversationId);

		if (componentInstanceMap == null) {
			componentInstanceMap = new ConcurrentHashMap<Contextual<?>, Object>();
			maxConversationBeanMap.put(COMPONENT_MAP_NAME+conversationId, componentInstanceMap);
		}

		return componentInstanceMap;
	}	

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}	
	
	
	public void setHttpSession(HttpSession session) {
		this.session = session;
	}

	private Map<String, Map<Contextual<?>, Object>> getMaxConversationBeanMap() {		
		
		@SuppressWarnings("unchecked")
		Map<String, Map<Contextual<?>, Object>> maxConversationBeanMap = (Map<String, Map<Contextual<?>, Object>>) session.getAttribute(MAX_CONVERSATION_BEAN_MAP);
		
		if(maxConversationBeanMap == null) {
			maxConversationBeanMap = new ConcurrentHashMap<>();
			session.setAttribute(MAX_CONVERSATION_BEAN_MAP,maxConversationBeanMap);
		}
		
		return maxConversationBeanMap;
		
	}

}
