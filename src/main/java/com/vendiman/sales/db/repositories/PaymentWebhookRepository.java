package com.vendiman.sales.db.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vendiman.sales.db.models.ContactStore;

import jakarta.transaction.Transactional;

@Repository
public interface PaymentWebhookRepository extends JpaRepository<ContactStore, Serializable> {

/*	@Modifying
	@Transactional
	@Query(value = "CALL AddContactNumberColumnToCurrentOrder()", nativeQuery = true)
	void executeAddContactNumberColumnProcedure(); */
	
	
	@Modifying
	@Transactional
 //  @Query(name = "CALL demo.usp_UpdateOrderContactNo(?,?)" , nativeQuery = true)
    @Procedure(procedureName = "usp_UpdateOrderContactNo" )
	void updateContactNumberByOrderId( @Param("orderId") Long orderId,@Param("ContactNumber") String ContactNumber);
	
	
	
	
	
	
/*	@Transactional
	@Modifying
	@Query("UPDATE ContactStore c SET c.ContactNumber = :ContactNumber WHERE c.orderId = :orderId")
	int updateContactNumberByOrderId( @Param("orderId") Long orderId,@Param("ContactNumber") String ContactNumber);  */

}
