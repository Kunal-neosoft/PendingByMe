package com.vendiman.sales.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendiman.dto.responses.ResponseOrderVO;
import com.vendiman.dto.responses.ResponseStatus;
import com.vendiman.dto.responses.ResponseVO;
import com.vendiman.sales.responses.PendingBalance;
import com.vendiman.sales.responses.PendingPaymentOrder;
import com.vendiman.sales.services.OrderService;
import com.vendiman.sales.db.models.CurrentOrder;
import com.vendiman.sales.db.models.Order;


@RestController
@RequestMapping("/api/v3/order")
public class OrderController {

	
	@Autowired
    private OrderService orderService;
	
	 @GetMapping("/pendingByMe")
	    ResponseEntity<?> getPendingPaymentOrdersOfLoggedInUser() {
	        ResponseVO<List<Order>> response = new ResponseVO<>();
	        ResponseVO<List<PendingPaymentOrder>> response1 = new ResponseVO<>();

	        try {
	         //   Integer consumerId = getAuthorizedUserId();
	        	Integer consumerId = 802;
	            List<CurrentOrder> pendingPaymentOrders = orderService.getPendingPaymentOrders(consumerId); 
	            
	   //       List<Order> pendingPaymentOrders = orderService.getPendingPaymentOrders(consumerId);
	            
	            List<CurrentOrder> list = new ArrayList<>();
	            List<PendingPaymentOrder> ppoList = new ArrayList<>();
	           
	            list.add(pendingPaymentOrders.get(0));
	            
	            if(!list.isEmpty()) {
	            	
	            	CurrentOrder ord = list.get(0);
	            	PendingPaymentOrder ppo = new PendingPaymentOrder();
	            	ppo.setOrderId(ord.getOrderId());
	            	ppo.setOrderNo(ord.getOrderNo());
	            	ppo.setOrderDate(ord.getDate());
	            	ppo.setTelemetrySerialNo(ord.getTelemetrySerialNo());
	            	ppo.setStatusId(ord.getPaymentStatusId());
	            	ppo.setCurrency(ord.getCurrency());
	            	ppo.setPaidAmount(ord.getPaidAmount());
	            	ppo.setBalanceAmount(ord.getBalanceAmount());
	            	ppo.setOrderTotal(ord.getAmount());
	            	ppo.setConsumerId(ord.getConsumerId());
	            	ppo.setConsumerName(ord.getConsumerName());
	            	ppoList.add(ppo);
	            	
	            }
	            
	         // response.setModel(pendingPaymentOrders);   
	            response1.setModel(ppoList);
	            response1.setMessage("Orders with pending payment has been fetched successfully");
	            response1.setStatus(ResponseStatus.SUCCESS);
	          //  response.setStatus(ResponseStatus.SUCCESS);
	          //  response.setMessage("Orders with pending payment has been fetched successfully");

	       /*     return new ResponseEntity<ResponseVO<List<Order>>>(
	                response, HttpStatus.OK
	            );  */
	            return new ResponseEntity<ResponseVO<List<PendingPaymentOrder>>>(
		                response1, HttpStatus.OK );  
	            
	           
	            
	        } catch (Exception ex) {
	        //    log.error("Error in getPendingOrdersOfLoggedInUser()", ex);
	        	response1.setStatus(ResponseStatus.ERROR);
	        	response1.setErrorMessage(ex.getMessage());
	            return new ResponseEntity<ResponseVO<List<PendingPaymentOrder>>>(
	            		response1, HttpStatus.INTERNAL_SERVER_ERROR
	            );
	        }
	    }
	 
	 
	 
	
	
}
