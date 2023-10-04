package com.vendiman.sales.services;

import java.util.List;

import com.vendiman.sales.db.models.CurrentOrder;
import com.vendiman.sales.db.models.Order;
/*

import com.vendiman.dto.responses.PaginatedList;
import com.vendiman.payment.requests.InitiatePaymentRequest;
import com.vendiman.payment.requests.ProcessPaymentRequest;
import com.vendiman.payment.response.PaymentInitiateResponse;
import com.vendiman.payment.response.PaymentTransactionResponse;
import com.vendiman.sales.requests.FinalizeOrderRequest;
import com.vendiman.sales.requests.UpdateOrderRequest;
import com.vendiman.sales.requests.UpdatePaymentStatusRequest;
import com.vendiman.sales.responses.FinalizedOrder;
import com.vendiman.sales.responses.MachineUseResponse;
import com.vendiman.sales.responses.OrderResponse;
import com.vendiman.sales.responses.SaleTransactionData;
*/
import com.vendiman.sales.responses.PendingPaymentOrder;

/**
 * 
 * @author Rineez Ahmed
 *
 */
public interface OrderService {

 //  PaginatedList<OrderResponse> getRecentOrdersForConsumer(Integer consumerId, Integer limit);

	/*
	 * PaginatedList<OrderResponse> getOrdersForConsumer(Integer consumerId, Integer
	 * pageIndex, Integer limit);
	 * 
	 * PaginatedList<MachineUseResponse> getMachinesUsedByConsumer(Integer
	 * consumerId, Integer pageIndex, Integer limit);
	 * 
	 * void updateOrderTemporary(Long orderId, UpdateOrderRequest request);
	 * 
	 * void updateOrderStatus(Long orderId, int newStatus) throws Exception;
	 * 
	 * FinalizedOrder finalizeOrder(Long orderId, FinalizeOrderRequest request)
	 * throws Exception;
	 * 
	 * PaymentInitiateResponse createTransaction(InitiatePaymentRequest request);
	 * 
	 * PaymentTransactionResponse processTransaction(String merchantReferenceId,
	 * ProcessPaymentRequest request) throws Exception;
	 * 
	 * PaymentTransactionResponse paymentResultCallback(String pspId, String
	 * paymentResult) throws Exception;
	 * 
	 * PaymentStatusData updatePaymentStatus(UpdatePaymentStatusRequest request)
	 * throws Exception;
	 */

    List<CurrentOrder> getPendingPaymentOrders(Integer consumerId) throws Exception;
    
	/*
	 * List<PendingPaymentOrder> getAllPendingPaymentOrders() throws Exception;
	 * 
	 * List<SaleTransactionData> getTransactionsByConsumerId(Integer consumerId,
	 * String paymentModes, String fromDate, String toDate) throws Exception;
	 */

}
