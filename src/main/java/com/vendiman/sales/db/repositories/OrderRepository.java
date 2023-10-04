package com.vendiman.sales.db.repositories;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendiman.sales.db.models.CurrentOrder;
import com.vendiman.sales.db.models.Order;
import com.vendiman.sales.db.models.OrderStatus;
/*import com.vendiman.sales.responses.MachineUseResponse;
*/import com.vendiman.sales.responses.PendingPaymentOrder;

/**
 * @author rineez
 *
 */
public interface OrderRepository extends BaseRepository<Order, Long> {

 //   Page<Order> findByConsumerId(Pageable page, @Param("ConsumerId") Integer consumerId);

  /* previous query of pending by me  orderRepo.getPendingPaymentOrdersByConsumer(consumerId,
					OrderStatus.PAYMENT_PENDING, OrderStatus.SUCCESS);
					
   *  @Query("SELECT new com.vendiman.sales.responses.PendingPaymentOrder("
        + "o.orderId, o.orderNo, o.date, o.telemetrySerialNo, o.paymentStatusId, o.statusId, o.currency, "
        + "o.paidAmount, o.balanceAmount, o.amount,o.consumerId, o.consumerName) "
        + "FROM Order o "
        + "WHERE o.consumerId = :ConsumerId AND o.statusId = :OrderStatusId "
        + "AND o.paymentStatusId = :PaymentStatusId AND o.balanceAmount>0 "
        + "ORDER BY o.date DESC")
    List<PendingPaymentOrder> getPendingPaymentOrdersByConsumer(
        @Param("ConsumerId") Integer consumerId, @Param("PaymentStatusId") int paymentStatusId,
        @Param("OrderStatusId") int orderStatusId); */
// IMP dont delete	@Query(nativeQuery=true,value="SELECT * from tblcurrentorder o WHERE o.consumerId = ?1 AND o.statusId = ?2 AND o.paymentStatusId =?3 AND o.balanceAmount>0 ORDER BY o.date DESC")

	@Query(nativeQuery=true,value="SELECT * from tblcurrentorder o WHERE o.consumerId = ?1 AND o.statusId = ?2 AND o.paymentStatusId =?3 AND o.balanceAmount>0 ORDER BY o.date DESC")
	List<Order> getPendingPaymentOrdersByConsumer(
	        @Param("ConsumerId") Integer consumerId,@Param("OrderStatusId") int orderStatusId, @Param("PaymentStatusId") int paymentStatusId
	        );

	/*
	 * @Query("SELECT distinct new com.vendiman.sales.responses.MachineUseResponse("
	 * +
	 * "o.machineId, o.machineNo, o.machineName, max(o.date), o.machineUid, o.latitude, o.longitude"
	 * + ") FROM Order o WHERE o.consumerId = :ConsumerId" +
	 * " GROUP BY o.machineId, o.machineNo, o.machineUid" +
	 * " ORDER BY max(o.date) DESC") Page<MachineUseResponse>
	 * getMachinesUsedByConsumer(Pageable page, @Param("ConsumerId") Integer
	 * consumerId);
	 * 
	 * @Query("SELECT new com.vendiman.sales.responses.PendingPaymentOrder(" +
	 * "o.orderId, o.orderNo, o.date, o.telemetrySerialNo, o.paymentStatusId, o.statusId, o.currency, "
	 * + "o.paidAmount, o.balanceAmount, o.amount, o.consumerId, o.consumerName" +
	 * ") FROM Order o " +
	 * "WHERE o.statusId = :OrderStatusId AND o.paymentStatusId = :PaymentStatusId AND o.balanceAmount>0 "
	 * + "ORDER BY o.date DESC") List<PendingPaymentOrder>
	 * getCurrentPendingPaymentOrders(
	 * 
	 * @Param("PaymentStatusId") int paymentStatusId,
	 * 
	 * @Param("OrderStatusId") int orderStatusId);
	 */
    
}
