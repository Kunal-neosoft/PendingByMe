package com.vendiman.sales.db.models;

public interface OrderStatus {

    int PENDING = 0;

    int SUCCESS = 1;

    int INITIATED = 2;

    int ITEM_NOT_FOUND = 3;

    int CANCELLED = 4;

    int FAILED = 5;

    int OUT_OF_STOCK = 6;

    int PAYMENT_PENDING = 7;

    int PAYMENT_COMPLETED = 8;

    int NOT_INITIATED = 9;

    int VEND_REQUESTED = 10;

    int VEND_INPROGRESS = 11;
    
    int FINALIZING = 12;

}