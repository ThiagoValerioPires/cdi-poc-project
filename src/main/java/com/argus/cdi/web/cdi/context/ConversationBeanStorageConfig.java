package com.argus.cdi.web.cdi.context;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpSession;

@RequestScoped
public interface ConversationBeanStorageConfig {
	
	void setConversationId(String conversationId);	
	
	void setHttpSession(HttpSession session);

}
