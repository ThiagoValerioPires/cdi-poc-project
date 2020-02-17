package com.argus.cdi.business;

import java.io.Serializable;

import com.argus.cdi.web.cdi.context.ConversationScoped;

@ConversationScoped
public class Counter implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private Integer actualValue;

	public Integer getActualValue() {
		return actualValue;
	}

	public void setActualValue(Integer actualValue) {
		this.actualValue = actualValue;
	}
	
	
	


	
	
	

}
