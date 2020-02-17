package com.argus.cdi.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.argus.cdi.business.Counter;
import com.argus.cdi.business.Person;




@Named
@RequestScoped
public class MainBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String conversationId;
	
	@Inject
	Counter counter;	
	
	@Inject
	Person person;
	
	public void increment() {		
		
		if(counter.getActualValue() == null) {
			counter.setActualValue(0);
		}
		counter.setActualValue(counter.getActualValue()+1);
		
		if(person.getName()==null) {
			person.setName("Person"+conversationId);
			person.setEmail("person"+conversationId+"@gmail.com");
		}
		
		System.out.println(counter.toString()+", "+person.toString());
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String interactionId) {
		this.conversationId = interactionId;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	

	
	
	
	

}
