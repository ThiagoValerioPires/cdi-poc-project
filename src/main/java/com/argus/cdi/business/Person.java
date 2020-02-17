package com.argus.cdi.business;

import java.io.Serializable;

import com.argus.cdi.web.cdi.context.ConversationScoped;


@ConversationScoped
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
