package com.argus.cdi.web.cdi.context;



public abstract class ConversationBeanStorageFactory {
	
	private static ThreadLocal<ConversationBeanStorageImpl> STORAGES = new ThreadLocal<>();
	
	public static ConversationBeanStorage getInstance() {
		return getMaxConversationBeanStorageImpl();
	}	
	
	public static ConversationBeanStorageConfig getConfigInstance() {
		return getMaxConversationBeanStorageImpl();
	}
	
	public static void remove() {
		STORAGES.remove();
	}
	
	private static ConversationBeanStorageImpl getMaxConversationBeanStorageImpl() {
		
		if(STORAGES.get() == null) {
			STORAGES.set(new ConversationBeanStorageImpl());
		}
		
		return STORAGES.get();
		
	}
	


}
