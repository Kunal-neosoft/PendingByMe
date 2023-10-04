package com.vendiman.sales.responses;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingPaymentOrder {

    private Long orderId;

    private String orderNo;
  
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime orderDate;

    private String telemetrySerialNo;

    private Integer paymentStatus;

    private Integer statusId;

    private String currency;

    private BigDecimal paidAmount;

    private BigDecimal balanceAmount;

    private BigDecimal orderTotal;
    
    private Integer consumerId;
    
    private String consumerName;

}
