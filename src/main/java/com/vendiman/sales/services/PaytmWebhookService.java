package com.vendiman.sales.services;

public interface PaytmWebhookService {
	
		boolean addContact(); 
	 
	  boolean updateContactNumberByOrderId( Long orderId,String contactNumber);

}
