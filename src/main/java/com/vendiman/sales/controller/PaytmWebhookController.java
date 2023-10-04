package com.vendiman.sales.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendiman.sales.db.models.PaymentPayload;
import com.vendiman.sales.services.PaytmWebhookService;

@RestController
@RequestMapping("/api")
public class PaytmWebhookController {

	private ObjectMapper objectMapper;

	@Autowired
	private PaytmWebhookService paymentWebhookService;

	@PostMapping("/paytm-webhook")
	public ResponseEntity<String> handlePaytmWebhook(@RequestBody PaymentPayload paymentPayload)
			throws JsonProcessingException {
		// Handle the Paytm webhook data here

		String currency = paymentPayload.getCurrency();
		String posId = paymentPayload.getPosId();
		String gatewayName = paymentPayload.getGatewayName();
		String respMsg = paymentPayload.getRespMsg();

		String bankName = paymentPayload.getBankName();
		String paymentMode = paymentPayload.getPaymentMode();
		String custId = paymentPayload.getCustId();
		String mid = paymentPayload.getMid();
		Long orderid = paymentPayload.getOrderId();
		String merc = paymentPayload.getMerchantUniqueRef();

		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString;

			jsonString = objectMapper.writeValueAsString(paymentPayload);

			// URLs-encode the JSON string

			String encodedData = URLEncoder.encode(jsonString, "UTF-8");
		} catch (UnsupportedEncodingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		try {
			boolean recordUpdate = paymentWebhookService.updateContactNumberByOrderId(orderid, merc);

			if (recordUpdate) {
				System.out.println("contact Added successfully");

			} else {

				System.out.println("contact addition failed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Respond with a success status
		return ResponseEntity.ok("Webhook received and processed successfully");
	}

	///////////////////////////////////////////////////////////////////

	
	
	/*
	 * @PostMapping("/paytm-webhook") public ResponseEntity<String>
	 * handlePaytmWebhook(@RequestBody MultiValueMap<String, String> formData)
	 * throws JsonProcessingException { // Handle the Paytm webhook data here
	 * 
	 * String currency = formData.getFirst("CURRENCY"); String posId =
	 * formData.getFirst("POS_ID"); String gatewayName =
	 * formData.getFirst("GATEWAYNAME");
	 * 
	 * String orderIdStr =formData.getFirst("ORDERID"); long orderId =
	 * Long.parseLong(orderIdStr); String merc =formData.getFirst("MERC_UNQ_REF");
	 * 
	 * try { // ObjectMapper objectMapper = new ObjectMapper(); // String
	 * 
	 * // jsonString = objectMapper.writeValueAsString(paymentPayload);
	 * 
	 * // URL-encode the JSON string
	 * 
	 * // String encodedData = URLEncoder.encode(jsonString, "UTF-8"); } catch
	 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * try { boolean recordUpdate =
	 * paymentWebhookService.updateContactNumberByOrderId(orderId, merc);
	 * 
	 * if (recordUpdate) { System.out.println("contact Added successfully");
	 * 
	 * } else {
	 * 
	 * System.out.println("contact addition failed"); } } catch (Exception ex) {
	 * ex.printStackTrace(); }
	 * 
	 * // Respond with a success status return
	 * ResponseEntity.ok("Webhook received and processed successfully"); }
	 * 
	 * 
	 * }
	 */
}