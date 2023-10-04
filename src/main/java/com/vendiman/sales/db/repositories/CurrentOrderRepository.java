package com.vendiman.sales.db.repositories;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendiman.sales.db.models.CurrentOrder;
/*import com.vendiman.sales.responses.MachineUseResponse;
*/import com.vendiman.sales.responses.PendingPaymentOrder;

public interface CurrentOrderRepository extends BaseRepository<CurrentOrder, Long> {

	/*
	 * Page<CurrentOrder> findByConsumerId(Pageable page, @Param("ConsumerId")
	 * Integer consumerId);
	 */
  /*   @Query("SELECT new com.vendiman.sales.responses.PendingPaymentOrder("
        + "o.orderId,o.orderNo,o.date,o.telemetrySerialNo,o.paymentStatusId,o.statusId,o.currency,"
        + "o.paidAmount,o.balanceAmount,o.amount, o.consumerId, o.consumerName)"
        + " FROM CurrentOrder o "
        + " WHERE o.consumerId = :ConsumerId AND o.statusId = :OrderStatusId "
        + " AND o.paymentStatusId = :PaymentStatusId AND o.balanceAmount>0"
        + " ORDER BY o.date DESC")
    List<PendingPaymentOrder> getCurrentPendingPaymentOrdersByConsumer(
        @Param("ConsumerId") Integer consumerId, @Param("PaymentStatusId") int paymentStatusId, 
        @Param("OrderStatusId") int orderStatusId);
     */
	
	  @Query(nativeQuery=true , value ="SELECT * from tblcurrentorder o WHERE o.consumerId = ?1 AND o.statusId = ?2 AND o.paymentStatusId =?3 AND o.balanceAmount>0 ORDER BY o.date DESC ")
		    List<CurrentOrder> getCurrentPendingPaymentOrdersByConsumer( @Param("ConsumerId") Integer consumerId, @Param("OrderStatusId") int orderStatusId,@Param("PaymentStatusId") int paymentStatusId);
    
    

    /*    @Query("SELECT distinct new com.vendiman.sales.responses.MachineUseResponse("
        + "o.machineId, o.machineNo, o.machineName, max(o.date), o.machineUid, o.latitude, o.longitude"
        + ") FROM CurrentOrder o WHERE o.consumerId = :ConsumerId"
        + " GROUP BY o.machineId, o.machineNo, o.machineUid"
       + " ORDER BY max(o.date) DESC")
    Page<MachineUseResponse> getMachinesUsedByConsumer(Pageable page, @Param("ConsumerId") Integer consumerId);
    
    @Query("SELECT new com.vendiman.sales.responses.PendingPaymentOrder("
        + "o.orderId,o.orderNo,o.date,o.telemetrySerialNo,o.paymentStatusId,o.statusId,o.currency,"
        + "o.paidAmount,o.balanceAmount,o.amount, o.consumerId, o.consumerName)"
        + " FROM CurrentOrder o "
        + " WHERE  o.statusId = :OrderStatusId AND o.paymentStatusId = :PaymentStatusId AND o.balanceAmount>0"
        + " ORDER BY o.date DESC")
    List<PendingPaymentOrder> getCurrentPendingPaymentOrders(
        @Param("PaymentStatusId") int paymentStatusId, 
        @Param("OrderStatusId") int orderStatusId);
    */
}
