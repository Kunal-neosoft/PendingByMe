package com.vendiman.sales.db.models;

import java.io.Serializable;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.vendiman.sales.db.modelApi.OrderEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * New orders are always created in tblcurrentorder first. A daily scheduled event runs in
 * Mysql DB to move records from tblcurrentorder to tblorder
 * 
 * @author Rineez Ahmed
 *
 */
@Entity
@Table(name = "tblorder", indexes = {
    @Index(name = "ix_tblorder_Date_OpId", columnList = "Date,OperatorId"),
    @Index(name = "ix_tblorder_Date_Oploc", columnList = "StatusId,OperatorId,Date,OperationLocationId"),
    @Index(name = "ix_tblorder_consumer_order", columnList = "ConsumerId,StatusId,OperatorId,Date"),
    @Index(name = "ix_tblorder_orderno_operator", columnList = "OrderNo,OperatorId"),
    @Index(name = "ix_tblorder_status_date", columnList = "StatusId,Date")
})
public class Order implements Serializable, OrderEntity {

    private static final long serialVersionUID = 3120827226233868902L;

    /** Primary key. */
    protected static final String PK = "orderId";

    @Id
    @Column(name = "OrderId", unique = true, nullable = false, precision = 19)
    private Long orderId;

    @Column(name = "OrderNo", length = 50)
    private String orderNo;

    @Column(name = "OperatorId", precision = 10)
    private Integer operatorId;

    @Column(name = "OperationLocationId", precision = 10)
    private Integer operationLocationId;

    @Column(name = "OperationLocationName", length = 100)
    private String operationLocationName;

    @Column(name = "CustomerId", precision = 10)
    private Integer customerId;

    @Column(name = "CustomerName", length = 100)
    private String customerName;

    @Column(name = "CustomerLocationId", precision = 10)
    private Integer customerLocationId;

    @Column(name = "CustomerLocationName", length = 100)
    private String customerLocationName;

    @Column(name = "TelemetryId", precision = 10)
    private Integer telemetryId;

    @Column(name = "TelemetrySerialNo", length = 20)
    private String telemetrySerialNo;

    @Column(name = "TerminalId", precision = 10)
    private Integer terminalId;

    @Column(name = "TerminalSerialNo", length = 20)
    private String terminalSerialNo;

    @Column(name = "MachineType", length = 20)
    private String machineType;

    @Column(name = "MachineId", nullable = false, precision = 10)
    private Integer machineId;

    @Column(name = "MachineName", length = 100)
    private String machineName;

    @Column(name = "MachineNo", length = 100)
    private String machineNo;

    @Column(name = "MachineRefNo", length = 100)
    private String machineRefNo;

    @Column(name = "Date")
    private ZonedDateTime date;

    @Column(name = "ConsumerId", precision = 10)
    private Integer consumerId;

    @Column(name = "ConsumerName", length = 20)
    private String consumerName;

    @Column(name = "IsCashless", length = 1)
    private Boolean isCashless;

    @Column(name = "IsMultiVend", length = 1)
    private Boolean isMultiVend;

    @Column(name = "Currency", length = 10)
    private String currency;

    @Column(name = "Amount", precision = 18, scale = 4)
    private BigDecimal amount;

    @Column(name = "PaidAmount", precision = 18, scale = 4)
    private BigDecimal paidAmount;

    @Column(name = "BalanceAmount", precision = 18, scale = 4, insertable = false, updatable = false)
    private BigDecimal balanceAmount;

    @Column(name = "Latitude", length = 20)
    private String latitude;

    @Column(name = "Longitude", length = 20)
    private String longitude;

    @Column(name = "StatusId", precision = 10)
    private Integer statusId;

    @Column(name = "PaymentStatusId", precision = 10)
    private Integer paymentStatusId;

    @Column(name = "Remarks", length = 200)
    private String remarks;

    @Column(name = "CreatedOn")
    private ZonedDateTime createdOn;

    @Column(name = "ModifiedOn")
    private ZonedDateTime modifiedOn;

    @Column(name = "IsPartialPayment", length = 1, insertable = false, updatable = false)
    private Boolean isPartialPayment;

    @Column(name = "MachineUID", length = 50)
    private String machineUid;

    @Column(name = "StatusMessage", length = 100)
    private String statusMessage;

    @Column(name = "ActualAmount", precision = 10)
    private BigDecimal actualAmount;

    @Column(name = "Item", length = 150)
    private String item;

    @Column(name = "DiscountAmount", precision = 18, scale = 4)
    private BigDecimal discountAmount;

    @Column(name = "NetAmount", precision = 18, scale = 4)
    private BigDecimal netAmount;

    @Column(name = "Country", length = 100)
    private String country;

    @Column(name = "State", length = 100)
    private String state;

    @Column(name = "City", length = 100)
    private String city;

    @Column(name = "Aggregator", length = 100)
    private String aggregator;

    @Column(name = "Vertical", length = 100)
    private String vertical;

    @Column(name = "Segment", length = 100)
    private String segment;

    @Column(name = "CommercialType", length = 100)
    private String commercialType;

    @Column(name = "Margin", precision = 18, scale = 4)
    private BigDecimal margin;

    @Column(name = "VendStatus", length = 10)
    private String vendStatus;

    @Column(name = "DonationAmount", precision = 10)
    private Integer donationAmount;


    /** Default constructor. */
    public Order() {
        super();
    }

    /**
     * Access method for orderId.
     *
     * @return the current value of orderId
     */
    @Override
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Setter method for orderId.
     *
     * @param aOrderId the new value for orderId
     */
    @Override
    public void setOrderId(Long aOrderId) {
        orderId = aOrderId;
    }

    /**
     * Access method for orderNo.
     *
     * @return the current value of orderNo
     */
    @Override
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * Setter method for orderNo.
     *
     * @param aOrderNo the new value for orderNo
     */
    @Override
    public void setOrderNo(String aOrderNo) {
        orderNo = aOrderNo;
    }

    /**
     * Access method for operatorId.
     *
     * @return the current value of operatorId
     */
    @Override
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * Setter method for operatorId.
     *
     * @param aOperatorId the new value for operatorId
     */
    @Override
    public void setOperatorId(Integer aOperatorId) {
        operatorId = aOperatorId;
    }

    /**
     * Access method for operationLocationId.
     *
     * @return the current value of operationLocationId
     */
    @Override
    public Integer getOperationLocationId() {
        return operationLocationId;
    }

    /**
     * Setter method for operationLocationId.
     *
     * @param aOperationLocationId the new value for operationLocationId
     */
    @Override
    public void setOperationLocationId(Integer aOperationLocationId) {
        operationLocationId = aOperationLocationId;
    }

    /**
     * Access method for operationLocationName.
     *
     * @return the current value of operationLocationName
     */
    @Override
    public String getOperationLocationName() {
        return operationLocationName;
    }

    /**
     * Setter method for operationLocationName.
     *
     * @param aOperationLocationName the new value for operationLocationName
     */
    @Override
    public void setOperationLocationName(String aOperationLocationName) {
        operationLocationName = aOperationLocationName;
    }

    /**
     * Access method for customerId.
     *
     * @return the current value of customerId
     */
    @Override
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Setter method for customerId.
     *
     * @param aCustomerId the new value for customerId
     */
    @Override
    public void setCustomerId(Integer aCustomerId) {
        customerId = aCustomerId;
    }

    /**
     * Access method for customerName.
     *
     * @return the current value of customerName
     */
    @Override
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter method for customerName.
     *
     * @param aCustomerName the new value for customerName
     */
    @Override
    public void setCustomerName(String aCustomerName) {
        customerName = aCustomerName;
    }

    /**
     * Access method for customerLocationId.
     *
     * @return the current value of customerLocationId
     */
    @Override
    public Integer getCustomerLocationId() {
        return customerLocationId;
    }

    /**
     * Setter method for customerLocationId.
     *
     * @param aCustomerLocationId the new value for customerLocationId
     */
    @Override
    public void setCustomerLocationId(Integer aCustomerLocationId) {
        customerLocationId = aCustomerLocationId;
    }

    /**
     * Access method for customerLocationName.
     *
     * @return the current value of customerLocationName
     */
    @Override
    public String getCustomerLocationName() {
        return customerLocationName;
    }

    /**
     * Setter method for customerLocationName.
     *
     * @param aCustomerLocationName the new value for customerLocationName
     */
    @Override
    public void setCustomerLocationName(String aCustomerLocationName) {
        customerLocationName = aCustomerLocationName;
    }

    /**
     * Access method for telemetryId.
     *
     * @return the current value of telemetryId
     */
    @Override
    public Integer getTelemetryId() {
        return telemetryId;
    }

    /**
     * Setter method for telemetryId.
     *
     * @param aTelemetryId the new value for telemetryId
     */
    @Override
    public void setTelemetryId(Integer aTelemetryId) {
        telemetryId = aTelemetryId;
    }

    /**
     * Access method for telemetrySerialNo.
     *
     * @return the current value of telemetrySerialNo
     */
    @Override
    public String getTelemetrySerialNo() {
        return telemetrySerialNo;
    }

    /**
     * Setter method for telemetrySerialNo.
     *
     * @param aTelemetrySerialNo the new value for telemetrySerialNo
     */
    @Override
    public void setTelemetrySerialNo(String aTelemetrySerialNo) {
        telemetrySerialNo = aTelemetrySerialNo;
    }

    /**
     * Access method for terminalId.
     *
     * @return the current value of terminalId
     */
    @Override
    public Integer getTerminalId() {
        return terminalId;
    }

    /**
     * Setter method for terminalId.
     *
     * @param aTerminalId the new value for terminalId
     */
    @Override
    public void setTerminalId(Integer aTerminalId) {
        terminalId = aTerminalId;
    }

    /**
     * Access method for terminalSerialNo.
     *
     * @return the current value of terminalSerialNo
     */
    @Override
    public String getTerminalSerialNo() {
        return terminalSerialNo;
    }

    /**
     * Setter method for terminalSerialNo.
     *
     * @param aTerminalSerialNo the new value for terminalSerialNo
     */
    @Override
    public void setTerminalSerialNo(String aTerminalSerialNo) {
        terminalSerialNo = aTerminalSerialNo;
    }

    /**
     * Access method for machineType.
     *
     * @return the current value of machineType
     */
    @Override
    public String getMachineType() {
        return machineType;
    }

    /**
     * Setter method for machineType.
     *
     * @param aMachineType the new value for machineType
     */
    @Override
    public void setMachineType(String aMachineType) {
        machineType = aMachineType;
    }

    /**
     * Access method for machineId.
     *
     * @return the current value of machineId
     */
    @Override
    public Integer getMachineId() {
        return machineId;
    }

    /**
     * Setter method for machineId.
     *
     * @param aMachineId the new value for machineId
     */
    @Override
    public void setMachineId(Integer aMachineId) {
        machineId = aMachineId;
    }

    /**
     * Access method for machineName.
     *
     * @return the current value of machineName
     */
    @Override
    public String getMachineName() {
        return machineName;
    }

    /**
     * Setter method for machineName.
     *
     * @param aMachineName the new value for machineName
     */
    @Override
    public void setMachineName(String aMachineName) {
        machineName = aMachineName;
    }

    /**
     * Access method for machineNo.
     *
     * @return the current value of machineNo
     */
    @Override
    public String getMachineNo() {
        return machineNo;
    }

    /**
     * Setter method for machineNo.
     *
     * @param aMachineNo the new value for machineNo
     */
    @Override
    public void setMachineNo(String aMachineNo) {
        machineNo = aMachineNo;
    }

    /**
     * Access method for machineRefNo.
     *
     * @return the current value of machineRefNo
     */
    @Override
    public String getMachineRefNo() {
        return machineRefNo;
    }

    /**
     * Setter method for machineRefNo.
     *
     * @param aMachineRefNo the new value for machineRefNo
     */
    @Override
    public void setMachineRefNo(String aMachineRefNo) {
        machineRefNo = aMachineRefNo;
    }

    /**
     * Access method for date.
     *
     * @return the current value of date
     */
    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    @Override
    public void setDate(ZonedDateTime aDate) {
        date = aDate;
    }

    /**
     * Access method for consumerId.
     *
     * @return the current value of consumerId
     */
    @Override
    public Integer getConsumerId() {
        return consumerId;
    }

    /**
     * Setter method for consumerId.
     *
     * @param aConsumerId the new value for consumerId
     */
    @Override
    public void setConsumerId(Integer aConsumerId) {
        consumerId = aConsumerId;
    }

    /**
     * Access method for consumerName.
     *
     * @return the current value of consumerName
     */
    @Override
    public String getConsumerName() {
        return consumerName;
    }

    /**
     * Setter method for consumerName.
     *
     * @param aConsumerName the new value for consumerName
     */
    @Override
    public void setConsumerName(String aConsumerName) {
        consumerName = aConsumerName;
    }

    /**
     * Access method for isCashless.
     *
     * @return the current value of isCashless
     */
    @Override
    public Boolean getIsCashless() {
        return isCashless;
    }

    /**
     * Setter method for isCashless.
     *
     * @param aIsCashless the new value for isCashless
     */
    @Override
    public void setIsCashless(Boolean aIsCashless) {
        isCashless = aIsCashless;
    }

    /**
     * Access method for isMultiVend.
     *
     * @return the current value of isMultiVend
     */
    @Override
    public Boolean getIsMultiVend() {
        return isMultiVend;
    }

    /**
     * Setter method for isMultiVend.
     *
     * @param aIsMultiVend the new value for isMultiVend
     */
    @Override
    public void setIsMultiVend(Boolean aIsMultiVend) {
        isMultiVend = aIsMultiVend;
    }

    /**
     * Access method for currency.
     *
     * @return the current value of currency
     */
    @Override
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter method for currency.
     *
     * @param aCurrency the new value for currency
     */
    @Override
    public void setCurrency(String aCurrency) {
        currency = aCurrency;
    }

    /**
     * Access method for amount.
     *
     * @return the current value of amount
     */
    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    @Override
    public void setAmount(BigDecimal aAmount) {
        amount = aAmount;
    }

    /**
     * Access method for paidAmount.
     *
     * @return the current value of paidAmount
     */
    @Override
    public BigDecimal getPaidAmount() {
        return paidAmount == null ? BigDecimal.ZERO : paidAmount;
    }

    /**
     * Setter method for paidAmount.
     *
     * @param aPaidAmount the new value for paidAmount
     */
    @Override
    public void setPaidAmount(BigDecimal aPaidAmount) {
        paidAmount = aPaidAmount;
    }

    @Override
    public BigDecimal addPaidAmount(BigDecimal aPaidAmount) {
        BigDecimal sum = getPaidAmount().add(aPaidAmount);
        setPaidAmount(sum);
        return sum;
    }

    /**
     * Access method for balanceAmount.
     *
     * @return the current value of balanceAmount
     */
    @Override
    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Access method for latitude.
     *
     * @return the current value of latitude
     */
    @Override
    public String getLatitude() {
        return latitude;
    }

    /**
     * Setter method for latitude.
     *
     * @param aLatitude the new value for latitude
     */
    @Override
    public void setLatitude(String aLatitude) {
        latitude = aLatitude;
    }

    /**
     * Access method for longitude.
     *
     * @return the current value of longitude
     */
    @Override
    public String getLongitude() {
        return longitude;
    }

    /**
     * Setter method for longitude.
     *
     * @param aLongitude the new value for longitude
     */
    @Override
    public void setLongitude(String aLongitude) {
        longitude = aLongitude;
    }

    /**
     * Access method for statusId.
     *
     * @return the current value of statusId
     */
    @Override
    public Integer getStatusId() {
        return statusId;
    }

    /**
     * Setter method for statusId.
     *
     * @param aStatusId the new value for statusId
     */
    @Override
    public void setStatusId(Integer aStatusId) {
        statusId = aStatusId;
    }

    /**
     * Access method for paymentStatusId.
     *
     * @return the current value of paymentStatusId
     */
    @Override
    public Integer getPaymentStatusId() {
        return paymentStatusId;
    }

    /**
     * Setter method for paymentStatusId.
     *
     * @param aPaymentStatusId the new value for paymentStatusId
     */
    @Override
    public void setPaymentStatusId(Integer aPaymentStatusId) {
        paymentStatusId = aPaymentStatusId;
    }

    /**
     * Access method for remarks.
     *
     * @return the current value of remarks
     */
    @Override
    public String getRemarks() {
        return remarks;
    }

    /**
     * Setter method for remarks.
     *
     * @param aRemarks the new value for remarks
     */
    @Override
    public void setRemarks(String aRemarks) {
        remarks = aRemarks;
    }

    /**
     * Access method for createdOn.
     *
     * @return the current value of createdOn
     */
    @Override
    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    /**
     * Setter method for createdOn.
     *
     * @param aCreatedOn the new value for createdOn
     */
    @Override
    public void setCreatedOn(ZonedDateTime aCreatedOn) {
        createdOn = aCreatedOn;
    }

    /**
     * Access method for modifiedOn.
     *
     * @return the current value of modifiedOn
     */
    @Override
    public ZonedDateTime getModifiedOn() {
        return modifiedOn;
    }

    /**
     * Setter method for modifiedOn.
     *
     * @param aModifiedOn the new value for modifiedOn
     */
    @Override
    public void setModifiedOn(ZonedDateTime aModifiedOn) {
        modifiedOn = aModifiedOn;
    }

    /**
     * Access method for isPartialPayment.
     *
     * @return the current value of isPartialPayment
     */
    @Override
    public Boolean getIsPartialPayment() {
        return isPartialPayment;
    }

    /**
     * Access method for machineUid.
     *
     * @return the current value of machineUid
     */
    @Override
    public String getMachineUid() {
        return machineUid;
    }

    /**
     * Setter method for machineUid.
     *
     * @param aMachineUid the new value for machineUid
     */
    @Override
    public void setMachineUid(String aMachineUid) {
        machineUid = aMachineUid;
    }

    /**
     * Access method for statusMessage.
     *
     * @return the current value of statusMessage
     */
    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Setter method for statusMessage.
     *
     * @param aStatusMessage the new value for statusMessage
     */
    @Override
    public void setStatusMessage(String aStatusMessage) {
        statusMessage = aStatusMessage;
    }

    /**
     * Access method for actualAmount.
     *
     * @return the current value of actualAmount
     */
    @Override
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * Setter method for actualAmount.
     *
     * @param aActualAmount the new value for actualAmount
     */
    @Override
    public void setActualAmount(BigDecimal aActualAmount) {
        actualAmount = aActualAmount;
    }

    /**
     * Access method for item.
     *
     * @return the current value of item
     */
    @Override
    public String getItem() {
        return item;
    }

    /**
     * Setter method for item.
     *
     * @param aItem the new value for item
     */
    @Override
    public void setItem(String aItem) {
        item = aItem;
    }

    /**
     * Access method for discountAmount.
     *
     * @return the current value of discountAmount
     */
    @Override
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Setter method for discountAmount.
     *
     * @param aDiscountAmount the new value for discountAmount
     */
    @Override
    public void setDiscountAmount(BigDecimal aDiscountAmount) {
        discountAmount = aDiscountAmount;
    }

    /**
     * Access method for netAmount.
     *
     * @return the current value of netAmount
     */
    @Override
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    /**
     * Setter method for netAmount.
     *
     * @param aNetAmount the new value for netAmount
     */
    @Override
    public void setNetAmount(BigDecimal aNetAmount) {
        netAmount = aNetAmount;
    }

    /**
     * Access method for country.
     *
     * @return the current value of country
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for country.
     *
     * @param aCountry the new value for country
     */
    @Override
    public void setCountry(String aCountry) {
        country = aCountry;
    }

    /**
     * Access method for state.
     *
     * @return the current value of state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * Setter method for state.
     *
     * @param aState the new value for state
     */
    @Override
    public void setState(String aState) {
        state = aState;
    }

    /**
     * Access method for city.
     *
     * @return the current value of city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Setter method for city.
     *
     * @param aCity the new value for city
     */
    @Override
    public void setCity(String aCity) {
        city = aCity;
    }

    /**
     * Access method for aggregator.
     *
     * @return the current value of aggregator
     */
    @Override
    public String getAggregator() {
        return aggregator;
    }

    /**
     * Setter method for aggregator.
     *
     * @param aAggregator the new value for aggregator
     */
    @Override
    public void setAggregator(String aAggregator) {
        aggregator = aAggregator;
    }

    /**
     * Access method for vertical.
     *
     * @return the current value of vertical
     */
    @Override
    public String getVertical() {
        return vertical;
    }

    /**
     * Setter method for vertical.
     *
     * @param aVertical the new value for vertical
     */
    @Override
    public void setVertical(String aVertical) {
        vertical = aVertical;
    }

    /**
     * Access method for segment.
     *
     * @return the current value of segment
     */
    @Override
    public String getSegment() {
        return segment;
    }

    /**
     * Setter method for segment.
     *
     * @param aSegment the new value for segment
     */
    @Override
    public void setSegment(String aSegment) {
        segment = aSegment;
    }

    /**
     * Access method for commercialType.
     *
     * @return the current value of commercialType
     */
    @Override
    public String getCommercialType() {
        return commercialType;
    }

    /**
     * Setter method for commercialType.
     *
     * @param aCommercialType the new value for commercialType
     */
    @Override
    public void setCommercialType(String aCommercialType) {
        commercialType = aCommercialType;
    }

    /**
     * Access method for margin.
     *
     * @return the current value of margin
     */
    @Override
    public BigDecimal getMargin() {
        return margin;
    }

    /**
     * Setter method for margin.
     *
     * @param aMargin the new value for margin
     */
    @Override
    public void setMargin(BigDecimal aMargin) {
        margin = aMargin;
    }

    /**
     * Access method for vendStatus.
     *
     * @return the current value of vendStatus
     */
    @Override
    public String getVendStatus() {
        return vendStatus;
    }

    /**
     * Setter method for vendStatus.
     *
     * @param aVendStatus the new value for vendStatus
     */
    @Override
    public void setVendStatus(String aVendStatus) {
        vendStatus = aVendStatus;
    }

    /**
     * Access method for donationAmount.
     *
     * @return the current value of donationAmount
     */
    @Override
    public Integer getDonationAmount() {
        return donationAmount;
    }

    /**
     * Setter method for donationAmount.
     *
     * @param aDonationAmount the new value for donationAmount
     */
    @Override
    public void setDonationAmount(Integer aDonationAmount) {
        donationAmount = aDonationAmount;
    }

    /**
     * Compares the key for this instance with another Order.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Order and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Order)) {
            return false;
        }
        Order that = (Order) other;
        Object myOrderId = this.getOrderId();
        Object yourOrderId = that.getOrderId();
        if (myOrderId == null ? yourOrderId != null : !myOrderId.equals(yourOrderId)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Order.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Order))
            return false;
        return this.equalKeys(other) && ((Order) other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        if (getOrderId() == null) {
            i = 0;
        } else {
            i = getOrderId().hashCode();
        }
        result = 37 * result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Order |");
        sb.append(" orderId=").append(getOrderId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("orderId", getOrderId());
        return ret;
    }

}
