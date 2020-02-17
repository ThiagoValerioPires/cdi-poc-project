package com.argus.cdi.web.cdi.context;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class ConversationFilter implements Filter {
	
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		//Do Nothing
	}	

	@Override
	public void destroy() {
		//Do Nothing
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		ConversationBeanStorageFactory.getConfigInstance().setConversationId(request.getParameter("form:conversationId"));				
		ConversationBeanStorageFactory.getConfigInstance().setHttpSession(((HttpServletRequest)request).getSession(true));
				
		chain.doFilter(request, response);		
		
		ConversationBeanStorageFactory.remove();
		
	}



}
