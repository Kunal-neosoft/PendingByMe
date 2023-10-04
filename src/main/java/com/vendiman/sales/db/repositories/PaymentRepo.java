package com.vendiman.sales.db.repositories;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PaymentRepo {
	
//	
 //   @PersistenceContext(unitName = demo) // databasename
    private EntityManager entityManager;
	
	

}
