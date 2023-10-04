/**
 * 
 */
package com.vendiman.sales.services.impl;

import java.math.BigDecimal;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendiman.sales.db.models.CurrentOrder;
import com.vendiman.sales.db.models.Order;
import com.vendiman.sales.db.models.OrderStatus;
import com.vendiman.sales.db.repositories.CurrentOrderRepository;
import com.vendiman.sales.db.repositories.OrderRepository;
import com.vendiman.sales.responses.PendingPaymentOrder;
import com.vendiman.sales.services.OrderService;

/*import com.vendiman.dto.responses.PaginatedList;
import com.vendiman.dto.responses.ResponseStatus;
import com.vendiman.payment.requests.InitiatePaymentRequest;
import com.vendiman.payment.requests.ProcessPaymentRequest;
import com.vendiman.payment.requests.RefundRequest;
import com.vendiman.payment.response.PaymentInitiateResponse;
import com.vendiman.payment.response.PaymentTransactionData;
import com.vendiman.payment.response.PaymentTransactionResponse;
import com.vendiman.payment.response.RefundResponse;
import com.vendiman.sales.db.modelApi.OrderEntity;
import com.vendiman.sales.db.models.MachineType;
import com.vendiman.sales.db.models.OrderStatus;
import com.vendiman.sales.db.models.PaymentStatus;
import com.vendiman.sales.db.modelss.CurrentOrder;
import com.vendiman.sales.db.modelss.CurrentPayment;
import com.vendiman.sales.db.modelss.OffsetBasedPageRequest;
import com.vendiman.sales.db.modelss.Order;
import com.vendiman.sales.db.modelss.SortKey;
import com.vendiman.sales.db.modelss.TempOrderItem;
import com.vendiman.sales.db.repositories.CurrentOrderRepository;
import com.vendiman.sales.db.repositories.CurrentPaymentRepository;
import com.vendiman.sales.db.repositories.OrderRepository;
import com.vendiman.sales.db.repositories.TempOrderItemRepository;
import com.vendiman.sales.mappers.OrderMapper;
import com.vendiman.sales.requests.FinalizeOrderRequest;
import com.vendiman.sales.requests.ProductTransaction;
import com.vendiman.sales.requests.UpdateOrderRequest;
import com.vendiman.sales.requests.UpdatePaymentStatusRequest;
import com.vendiman.sales.responses.FinalizedOrder;
import com.vendiman.sales.responses.MachineUseResponse;
import com.vendiman.sales.responses.OrderResponse;
import com.vendiman.sales.responses.PaymentStatusData;
import com.vendiman.sales.responses.PendingPaymentOrder;
import com.vendiman.sales.responses.SaleTransactionData;
import com.vendiman.sales.services.OrderService;
import com.vendiman.sales.services.PaymentService;
import com.vendiman.sales.services.PaymentV1Service;
import com.vendiman.sales.services.WalletAggregatorV1Service;
import com.vendiman.sales.services.impl.helpers.OrderFinalizeHelper;
import com.vendiman.sales.services.impl.helpers.OrderTransactionHelper;
import com.vendiman.walletAggrv1.responses.AutoVendNowResponse;*/

import lombok.extern.slf4j.Slf4j;

/**
 * @author rineez
 *
 */
/**
 * @author Rineez Ahmed
 *
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
    private CurrentOrderRepository currentOrderRepo;
	
	@Autowired
    private OrderRepository orderRepo;


	/*
	 * @Autowired private PaymentService paymentService;
	 * 
	 * @Autowired private OrderRepository orderRepo;
	 * 
	 * @Autowired private CurrentOrderRepository currentOrderRepo;
	 * 
	 * @Autowired private CurrentPaymentRepository currentPaymentRepo;
	 * 
	 * @Autowired private TempOrderItemRepository tempOrderItemRepo;
	 * 
	 * private OrderMapper orderMapper = OrderMapper.INSTANCE;
	 * 
	 * @Autowired private PaymentV1Service paymentV1Service;
	 * 
	 * @Autowired private OrderFinalizeHelper orderFinalizeHelper;
	 * 
	 * @Autowired private OrderTransactionHelper orderTransactionHelper;
	 * 
	 * @Autowired private WalletAggregatorV1Service walletAggrV1Service;
	 * 
	 * 
	 * @Override public FinalizedOrder finalizeOrder(Long orderId,
	 * FinalizeOrderRequest request) throws Exception { return
	 * orderFinalizeHelper.finalizeOrder(orderId, request); }
	 * 
	 * private OrderEntity findOrderById(Long orderId) { Optional<CurrentOrder>
	 * currentOrderResult = currentOrderRepo.findById(orderId); if
	 * (currentOrderResult.isEmpty()) { return
	 * orderRepo.findById(orderId).orElseThrow( () -> new
	 * EntityNotFoundException("No order found with Id: " + orderId) ); }
	 * 
	 * return currentOrderResult.get(); }
	 * 
	 * @Override public PaginatedList<OrderResponse>
	 * getRecentOrdersForConsumer(Integer consumerId, Integer limit) { return
	 * getOrdersForConsumer(consumerId, 0, limit); }
	 * 
	 * @Override public PaginatedList<OrderResponse> getOrdersForConsumer(Integer
	 * consumerId, Integer pageIndex, Integer limit) { Sort sortByCreatedAtDesc =
	 * Sort.by(Sort.Direction.DESC, SortKey.CREATED_AT.getName()); Pageable page =
	 * PageRequest.of(pageIndex, limit, sortByCreatedAtDesc); List<OrderResponse>
	 * orderResponses = new ArrayList<>();
	 * 
	 * Page<CurrentOrder> currentOrdersPage =
	 * currentOrderRepo.findByConsumerId(page, consumerId);
	 * 
	 * long totalElements = 0; int totalPages = 0; if (!currentOrdersPage.isEmpty())
	 * { orderResponses = orderMapper
	 * .currentOrderListToOrderResponseList(currentOrdersPage.getContent());
	 * totalElements = currentOrdersPage.getTotalElements(); totalPages =
	 * currentOrdersPage.getTotalPages(); }
	 * 
	 * Page<Order> ordersPage; if (orderResponses.size() < limit) { // Size of last
	 * page of Current orders int set1LastPageSize = (int) (totalElements % limit);
	 * int fillerCount = limit - set1LastPageSize;
	 * 
	 * int limit2; long offset; if (orderResponses.isEmpty()) { int pageIndex2 =
	 * pageIndex - totalPages; limit2 = limit; offset = limit2 * pageIndex2 +
	 * fillerCount; } else { // When result contain Current orders also // we fetch
	 * only enough to fill the remaining space in page limit2 = fillerCount; offset
	 * = 0; } Pageable remainingPage = new OffsetBasedPageRequest( offset, limit2,
	 * sortByCreatedAtDesc ); ordersPage = orderRepo.findByConsumerId(remainingPage,
	 * consumerId); orderResponses
	 * .addAll(orderMapper.orderListToOrderResponseList(ordersPage.getContent())); }
	 * else { // Creating a query just to get totalElements and totalPages
	 * ordersPage = orderRepo.findByConsumerId(page, consumerId); } totalElements =
	 * totalElements + ordersPage.getTotalElements(); totalPages = totalPages +
	 * ordersPage.getTotalPages();
	 * 
	 * return new PaginatedList<>(orderResponses, pageIndex, limit, totalElements,
	 * totalPages); }
	 * 
	 * @Override public PaginatedList<MachineUseResponse>
	 * getMachinesUsedByConsumer(Integer consumerId, Integer pageIndex, Integer
	 * limit) { Pageable page = PageRequest.of(pageIndex, limit);
	 * List<MachineUseResponse> usedMachines = new ArrayList<>();
	 * 
	 * Page<MachineUseResponse> currentOrdersPage = currentOrderRepo
	 * .getMachinesUsedByConsumer(page, consumerId);
	 * 
	 * long totalElements = 0; int totalPages = 0; if (!currentOrdersPage.isEmpty())
	 * { usedMachines.addAll(currentOrdersPage.getContent()); totalElements =
	 * currentOrdersPage.getTotalElements(); totalPages =
	 * currentOrdersPage.getTotalPages(); }
	 * 
	 * Page<MachineUseResponse> ordersPage; if (usedMachines.size() < limit) { //
	 * Size of last page of Current orders int set1LastPageSize = (int)
	 * (totalElements % limit); int fillerCount = limit - set1LastPageSize;
	 * 
	 * int limit2; long offset; if (usedMachines.isEmpty()) { int pageIndex2 =
	 * pageIndex - totalPages; limit2 = limit; offset = limit2 * pageIndex2 +
	 * (pageIndex2 > 0 ? fillerCount : 0); } else { // When result contain Current
	 * orders also // we fetch only enough to fill the remaining space in page
	 * limit2 = fillerCount; offset = 0; } Pageable remainingPage = new
	 * OffsetBasedPageRequest(offset, limit2, Sort.unsorted()); ordersPage =
	 * orderRepo.getMachinesUsedByConsumer(remainingPage, consumerId);
	 * usedMachines.addAll(ordersPage.getContent()); } else { // Creating a query
	 * just to get totalElements and totalPages ordersPage =
	 * orderRepo.getMachinesUsedByConsumer(page, consumerId); } totalElements =
	 * totalElements + ordersPage.getTotalElements(); totalPages = totalPages +
	 * ordersPage.getTotalPages();
	 * 
	 * return new PaginatedList<>(usedMachines, pageIndex, limit, totalElements,
	 * totalPages); }
	 * 
	 * @Override
	 * 
	 * @Transactional public void updateOrderTemporary(Long orderId,
	 * UpdateOrderRequest request) { int shelf = request.getShelf(); BigDecimal
	 * weightDiff = request.getWeightDiff(); // Expecting to get weight diff from
	 * the ZonedDateTime updateTime = request.getTimestamp();
	 * 
	 * // machine itself List<ProductTransaction> transactionList =
	 * request.getProductTransactions();
	 * 
	 * List<TempOrderItem> orderItemList = new ArrayList<>(transactionList.size());
	 * for (ProductTransaction productTransaction : transactionList) { Integer
	 * itemId = productTransaction.getItem(); int delta =
	 * productTransaction.getItemCount();
	 * 
	 * TempOrderItem orderItem = new TempOrderItem(); orderItem.setOrderId(orderId);
	 * orderItem.setItemId(itemId); orderItem.setQuantity(delta * -1);
	 * orderItem.setShelf(shelf); orderItem.setWeightDiff(weightDiff);
	 * orderItem.setCreatedOn(updateTime != null ? updateTime :
	 * ZonedDateTime.now()); orderItemList.add(orderItem); }
	 * 
	 * tempOrderItemRepo.saveAll(orderItemList); }
	 * 
	 * @Transactional
	 * 
	 * @Override public void updateOrderStatus(Long orderId, int newStatus) throws
	 * Exception {
	 * 
	 * OrderEntity order = findOrderById(orderId); order.setStatusId(newStatus); if
	 * (order instanceof CurrentOrder) { order =
	 * currentOrderRepo.save((CurrentOrder) order); } else { order =
	 * orderRepo.save((Order) order); } }
	 * 
	 * @Override public PaymentInitiateResponse
	 * createTransaction(InitiatePaymentRequest request) { return
	 * paymentService.createTransaction(request); }
	 * 
	 * @Override public PaymentTransactionResponse processTransaction(String
	 * merchantReferenceId, ProcessPaymentRequest request) throws Exception {
	 * PaymentTransactionResponse response = paymentService
	 * .processTransaction(merchantReferenceId, request); if (response.getStatus()
	 * == ResponseStatus.SUCCESS) { PaymentTransactionData transaction =
	 * response.getModel();
	 * 
	 * // For some payment modes payment may be already success at this point // In
	 * that case update the payment in order if (transaction.getPaymentStatusId() ==
	 * PaymentStatus.SUCCESS) { List<CurrentPayment> savedEntry = currentPaymentRepo
	 * .findByReferenceNo(transaction.getProviderReferenceId()); if
	 * (!savedEntry.isEmpty()) { return response; }
	 * 
	 * UpdatePaymentStatusRequest updateRequest = buildUpdatePaymentStatusRequest(
	 * transaction ); updatePaymentStatus(updateRequest); } } return response; }
	 * 
	 * @Override public PaymentTransactionResponse paymentResultCallback(String
	 * pspId, String paymentResult) throws Exception { PaymentTransactionResponse
	 * response = paymentService.resultCallback(pspId, paymentResult);
	 * log.info("paymentResultCallback() Payment result callback response: {}",
	 * response); PaymentTransactionData transaction = response.getModel();
	 * UpdatePaymentStatusRequest updateRequest =
	 * buildUpdatePaymentStatusRequest(transaction);
	 * updatePaymentStatus(updateRequest); return response; }
	 * 
	 * private UpdatePaymentStatusRequest buildUpdatePaymentStatusRequest(
	 * PaymentTransactionData transaction) { UpdatePaymentStatusRequest request =
	 * new UpdatePaymentStatusRequest();
	 * request.setOrderId(transaction.getOrderId());
	 * request.setPaidAmount(transaction.getAmount());
	 * request.setCurrency(transaction.getCurrency());
	 * request.setPaymentMode(transaction.getPaymentMode());
	 * request.setPaymentDescription(transaction.getPaymentDescription());
	 * request.setStatusId(transaction.getPaymentStatusId());
	 * request.setReferenceNo(transaction.getProviderReferenceId());
	 * request.setRemark(transaction.getRemarks());
	 * 
	 * return request;
	 * 
	 *//**
		 * OLD LOGIC TO REPLACE Long orderId = transaction.getOrderId();
		 * Optional<CurrentOrder> orderResult = currentOrderRepo.findById(orderId); if
		 * (orderResult.isEmpty()) { throw new EntityNotFoundException("No order found
		 * with Id: " + orderId); } BigDecimal authAmount = transaction.getAmount();
		 * CurrentOrder order = getCurrentOrderById(orderId); if
		 * (authAmount.compareTo(order.getBalanceAmount()) >= 0) {
		 * order.setStatusId(OrderStatus.PAYMENT_COMPLETED);
		 * order.setPaymentStatusId(PaymentStatus.SUCCESS); }
		 * order.addPaidAmount(authAmount); order = currentOrderRepo.save(order);
		 **//*
			 * }
			 * 
			 * @Override public PaymentStatusData
			 * updatePaymentStatus(UpdatePaymentStatusRequest request) { Long orderId =
			 * request.getOrderId(); OrderEntity order = findOrderById(orderId);
			 * 
			 * order = orderTransactionHelper.doUpdatePaymentStatus(order, request);
			 * 
			 * log.info("updatePaymentStatus() Order details: {}", order);
			 * 
			 * if (order.getPaymentStatusId().equals(PaymentStatus.SUCCESS)) { if
			 * (order.getStatusId().equals(OrderStatus.CANCELLED)) {
			 * 
			 * BigDecimal refundAmount = order.getAmount(); RefundRequest refundrequest =
			 * new RefundRequest(); refundrequest.setAmount(refundAmount.toPlainString());
			 * refundrequest.setApp_id(order.getOrderNo()); refundrequest.setSource("");
			 * refundrequest.setTelemetryId(order.getTelemetrySerialNo());
			 * refundrequest.setOrderId(order.getOrderId().toString());
			 * 
			 * log.info("updatePaymentStatus() Auto refund intiate request: {}",
			 * refundrequest); RefundResponse refundResponse =
			 * paymentV1Service.initiateRefund(refundrequest);
			 * log.info("updatePaymentStatus() Auto refund response: {}", refundResponse); }
			 * else { log.info("updatePaymentStatus() Order Success"); try { if
			 * (order.getMachineType().equals(String.valueOf(MachineType.SPIRAL))) {
			 * AutoVendNowResponse vendNowResponse = walletAggrV1Service
			 * .autoVendNow(orderId);
			 * log.info("updatePaymentStatus() Autovend response: {}", vendNowResponse); } }
			 * catch (Exception ex) {
			 * log.error("updatePaymentStatus(), Autovend failed: {}", ex.getMessage()); } }
			 * }
			 * 
			 * BigDecimal paidAmount = request.getPaidAmount(); String currency =
			 * request.getCurrency(); String paymentMode = request.getPaymentMode(); String
			 * accountNo = request.getAccountNo(); String referenceNo =
			 * request.getReferenceNo(); String paymentDescription =
			 * request.getPaymentDescription(); String remark = request.getRemark(); int
			 * statusId = request.getStatusId();
			 * 
			 * PaymentStatusData paymentStatusData = new PaymentStatusData();
			 * paymentStatusData.setOrderId(orderId);
			 * paymentStatusData.setPaidAmount(paidAmount);
			 * paymentStatusData.setPaymentMode(paymentMode);
			 * paymentStatusData.setCurrency(currency);
			 * paymentStatusData.setAccountNo(accountNo);
			 * paymentStatusData.setReferenceNo(referenceNo);
			 * paymentStatusData.setPaymentDescription(paymentDescription);
			 * paymentStatusData.setRemark(remark); paymentStatusData.setStatusId(statusId);
			 * 
			 * return paymentStatusData; }
			 */

/*	@Transactional
	public List<Order> getPendingPaymentOrders(Integer consumerId)  {
		List<Order> allOrders = new ArrayList<>();

		try {
			List<CurrentOrder> currentOrders = currentOrderRepo.getCurrentPendingPaymentOrdersByConsumer(consumerId,
					OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
		//	List<CurrentOrder> currentOrders = currentOrderRepo.getCurrentPendingPaymentOrdersByConsumer();
	//	List<PendingPaymentOrder> orders = orderRepo.getPendingPaymentOrdersByConsumer(consumerId,
	//			OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
			List<Order> orders = orderRepo.getPendingPaymentOrdersByConsumer(consumerId,
					OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
			
		if (currentOrders.size() > 0) {
			allOrders.addAll(currentOrders);
		}
		if (orders.size() > 0) {
			allOrders.addAll(orders);
		}

		return allOrders;
		}
		catch(Exception ex){
				log.info("error"+ex)		;
				}
		return null;
		
	} */
	
	
	@Transactional
	public List<CurrentOrder> getPendingPaymentOrders(Integer consumerId)  {
		List<CurrentOrder> allOrders = new ArrayList<>();

		try {
			List<CurrentOrder> currentOrders = currentOrderRepo.getCurrentPendingPaymentOrdersByConsumer(consumerId,
					OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
		//	List<pendingPaymentOrder> currentOrders = currentOrderRepo.getCurrentPendingPaymentOrdersByConsumer();
	
	   //	List<PendingPaymentOrder> orders = orderRepo.getPendingPaymentOrdersByConsumer(consumerId,
	  //		OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
			
	//		List<Order> orders = orderRepo.getPendingPaymentOrdersByConsumer(consumerId,
	//				OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
			
		if (currentOrders.size() > 0) {
			allOrders.addAll(currentOrders);
		} 
	/*	if (orders.size() > 0) {
			allOrders.addAll(orders);
		} */

		return allOrders;
		}
		catch(Exception ex){
				log.info("error"+ex)		;
				}
		return null;
		
	}

	/**
	 * -----------------------------------------------------------------------------
	 * Method to retrieve all orders which is in PAYMENT_PENDING state
	 * ------------------------------------------------------------------------------
	 *//*
		 * @Transactional public List<PendingPaymentOrder> getAllPendingPaymentOrders()
		 * throws Exception { List<PendingPaymentOrder> allOrders = new ArrayList<>();
		 * 
		 * List<PendingPaymentOrder> currentOrders = currentOrderRepo
		 * .getCurrentPendingPaymentOrders(OrderStatus.PAYMENT_PENDING,
		 * OrderStatus.SUCCESS); List<PendingPaymentOrder> orders =
		 * orderRepo.getCurrentPendingPaymentOrders(OrderStatus.PAYMENT_PENDING,
		 * OrderStatus.SUCCESS);
		 * 
		 * if (currentOrders.size() > 0) { allOrders.addAll(currentOrders); } if
		 * (orders.size() > 0) { allOrders.addAll(orders); } return allOrders; } //
		 * -----------------------------------------------------------------------------
		 * -------
		 * 
		 * @Override public List<SaleTransactionData>
		 * getTransactionsByConsumerId(Integer consumerId, String paymentModes, String
		 * fromDate, String toDate) throws Exception { List<SaleTransactionData> results
		 * = new ArrayList<>(); List<CurrentPayment> payments =
		 * currentPaymentRepo.getSaleTransactions(consumerId, paymentModes, fromDate,
		 * toDate);
		 * 
		 * payments.stream().forEach((payment) -> { Long orderId = payment.getOrderId();
		 * String paymentMode = payment.getPaymentMode(); String paymentDescription =
		 * payment.getDescription(); SaleTransactionData forwardTransaction = new
		 * SaleTransactionData(); forwardTransaction.setType("Paid");
		 * forwardTransaction.setOrderId(orderId);
		 * forwardTransaction.setPaymentMode(paymentMode);
		 * forwardTransaction.setPaymentDescription(paymentDescription);
		 * forwardTransaction.setPaymentReferenceNo(payment.getReferenceNo());
		 * forwardTransaction.setPaidAmount(payment.getPaidAmount()); String paidDate =
		 * ""; if (payment.getCreatedOn() != null) { paidDate =
		 * payment.getCreatedOn().toString(); }
		 * forwardTransaction.setPaidDate(paidDate); results.add(forwardTransaction);
		 * 
		 * if (payment.getRefundStatusId() != null && payment.getRefundStatusId() ==
		 * PaymentStatus.SUCCESS) { forwardTransaction.setRefunded(true);
		 * SaleTransactionData refundTransaction = new SaleTransactionData();
		 * refundTransaction.setType("Refunded"); refundTransaction.setOrderId(orderId);
		 * refundTransaction.setPaymentMode(paymentMode);
		 * refundTransaction.setPaymentDescription(paymentDescription);
		 * refundTransaction.setPaymentReferenceNo("");
		 * refundTransaction.setPaidAmount(payment.getRefundedAmount()); String
		 * refundedDate = ""; if (payment.getRefundedOn() != null) { refundedDate =
		 * payment.getRefundedOn().toString(); }
		 * refundTransaction.setPaidDate(refundedDate);
		 * 
		 * results.add(refundTransaction); } }); return results; }
		 */

}
