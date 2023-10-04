package com.vendiman.sales.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendiman.sales.db.repositories.PaymentWebhookRepository;
import com.vendiman.sales.services.PaytmWebhookService;

@Service
public class PaytmWebhookServiceImpl implements PaytmWebhookService {

	@Autowired
	PaymentWebhookRepository paymentWebhookRepo;

	@Override
	public boolean addContact() {
		return false;
	}

	@Override
	public boolean updateContactNumberByOrderId(Long orderId, String contactNumber) {

		try {

			paymentWebhookRepo.updateContactNumberByOrderId(orderId, contactNumber);
			System.out.println("contact added successfully");

			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}

}
