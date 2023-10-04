package com.vendiman.sales.db.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vendiman.sales.db.modelApi.OrderEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/*@Entity
@Table(name = "", indexes = {
    @Index(name = "uk_tblcurrentorder_orderno", columnList = "OrderNo", unique = true),
    @Index(name = "ix_tblcurrentorder_orderno_operator", columnList = "OrderNo,OperatorId")
}) */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPayload implements Serializable{
	    
	 @JsonProperty("CURRENCY")
	    private String currency;

	    @JsonProperty("POS_ID")
	    private String posId;

	    @JsonProperty("GATEWAYNAME")
	    private String gatewayName;

	    @JsonProperty("RESPMSG")
	    private String respMsg;

	    @JsonProperty("BANKNAME")
	    private String bankName;

	    @JsonProperty("PAYMENTMODE")
	    private String paymentMode;

	    @JsonProperty("CUSTID")
	    private String custId;

	    @JsonProperty("MID")
	    private String mid;

	    @JsonProperty("MERC_UNQ_REF")
	    private String merchantUniqueRef;

	    @JsonProperty("RESPCODE")
	    private String respCode;

	    @JsonProperty("Masked_customer_mobile_number")
	    private String maskedCustomerMobile;

	    @JsonProperty("TXNTYPE")
	    private String txnType;

	    @JsonProperty("TXNID")
	    private String txnId;

	    @JsonProperty("TXNAMOUNT")
	    private String txnAmount;

	    @JsonProperty("ORDERID")
	    private Long orderId;

	    @JsonProperty("STATUS")
	    private String status;
	    
	    
	    

}
