package com.vendiman.sales.db.modelApi;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;

public interface OrderEntity {

    /**
     * Access method for orderId.
     *
     * @return the current value of orderId
     */
    Long getOrderId();

    /**
     * Setter method for orderId.
     *
     * @param aOrderId the new value for orderId
     */
    void setOrderId(Long aOrderId);

    /**
     * Access method for orderNo.
     *
     * @return the current value of orderNo
     */
    String getOrderNo();

    /**
     * Setter method for orderNo.
     *
     * @param aOrderNo the new value for orderNo
     */
    void setOrderNo(String aOrderNo);

    /**
     * Access method for operatorId.
     *
     * @return the current value of operatorId
     */
    Integer getOperatorId();

    /**
     * Setter method for operatorId.
     *
     * @param aOperatorId the new value for operatorId
     */
    void setOperatorId(Integer aOperatorId);

    /**
     * Access method for operationLocationId.
     *
     * @return the current value of operationLocationId
     */
    Integer getOperationLocationId();

    /**
     * Setter method for operationLocationId.
     *
     * @param aOperationLocationId the new value for operationLocationId
     */
    void setOperationLocationId(Integer aOperationLocationId);

    /**
     * Access method for operationLocationName.
     *
     * @return the current value of operationLocationName
     */
    String getOperationLocationName();

    /**
     * Setter method for operationLocationName.
     *
     * @param aOperationLocationName the new value for operationLocationName
     */
    void setOperationLocationName(String aOperationLocationName);

    /**
     * Access method for customerId.
     *
     * @return the current value of customerId
     */
    Integer getCustomerId();

    /**
     * Setter method for customerId.
     *
     * @param aCustomerId the new value for customerId
     */
    void setCustomerId(Integer aCustomerId);

    /**
     * Access method for customerName.
     *
     * @return the current value of customerName
     */
    String getCustomerName();

    /**
     * Setter method for customerName.
     *
     * @param aCustomerName the new value for customerName
     */
    void setCustomerName(String aCustomerName);

    /**
     * Access method for customerLocationId.
     *
     * @return the current value of customerLocationId
     */
    Integer getCustomerLocationId();

    /**
     * Setter method for customerLocationId.
     *
     * @param aCustomerLocationId the new value for customerLocationId
     */
    void setCustomerLocationId(Integer aCustomerLocationId);

    /**
     * Access method for customerLocationName.
     *
     * @return the current value of customerLocationName
     */
    String getCustomerLocationName();

    /**
     * Setter method for customerLocationName.
     *
     * @param aCustomerLocationName the new value for customerLocationName
     */
    void setCustomerLocationName(String aCustomerLocationName);

    /**
     * Access method for telemetryId.
     *
     * @return the current value of telemetryId
     */
    Integer getTelemetryId();

    /**
     * Setter method for telemetryId.
     *
     * @param aTelemetryId the new value for telemetryId
     */
    void setTelemetryId(Integer aTelemetryId);

    /**
     * Access method for telemetrySerialNo.
     *
     * @return the current value of telemetrySerialNo
     */
    String getTelemetrySerialNo();

    /**
     * Setter method for telemetrySerialNo.
     *
     * @param aTelemetrySerialNo the new value for telemetrySerialNo
     */
    void setTelemetrySerialNo(String aTelemetrySerialNo);

    /**
     * Access method for terminalId.
     *
     * @return the current value of terminalId
     */
    Integer getTerminalId();

    /**
     * Setter method for terminalId.
     *
     * @param aTerminalId the new value for terminalId
     */
    void setTerminalId(Integer aTerminalId);

    /**
     * Access method for terminalSerialNo.
     *
     * @return the current value of terminalSerialNo
     */
    String getTerminalSerialNo();

    /**
     * Setter method for terminalSerialNo.
     *
     * @param aTerminalSerialNo the new value for terminalSerialNo
     */
    void setTerminalSerialNo(String aTerminalSerialNo);

    /**
     * Access method for machineType.
     *
     * @return the current value of machineType
     */
    String getMachineType();

    /**
     * Setter method for machineType.
     *
     * @param aMachineType the new value for machineType
     */
    void setMachineType(String aMachineType);

    /**
     * Access method for machineId.
     *
     * @return the current value of machineId
     */
    Integer getMachineId();

    /**
     * Setter method for machineId.
     *
     * @param aMachineId the new value for machineId
     */
    void setMachineId(Integer aMachineId);

    /**
     * Access method for machineName.
     *
     * @return the current value of machineName
     */
    String getMachineName();

    /**
     * Setter method for machineName.
     *
     * @param aMachineName the new value for machineName
     */
    void setMachineName(String aMachineName);

    /**
     * Access method for machineNo.
     *
     * @return the current value of machineNo
     */
    String getMachineNo();

    /**
     * Setter method for machineNo.
     *
     * @param aMachineNo the new value for machineNo
     */
    void setMachineNo(String aMachineNo);

    /**
     * Access method for machineRefNo.
     *
     * @return the current value of machineRefNo
     */
    String getMachineRefNo();

    /**
     * Setter method for machineRefNo.
     *
     * @param aMachineRefNo the new value for machineRefNo
     */
    void setMachineRefNo(String aMachineRefNo);

    /**
     * Access method for date.
     *
     * @return the current value of date
     */
    ZonedDateTime getDate();

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    void setDate(ZonedDateTime aDate);

    /**
     * Access method for consumerId.
     *
     * @return the current value of consumerId
     */
    Integer getConsumerId();

    /**
     * Setter method for consumerId.
     *
     * @param aConsumerId the new value for consumerId
     */
    void setConsumerId(Integer aConsumerId);

    /**
     * Access method for consumerName.
     *
     * @return the current value of consumerName
     */
    String getConsumerName();

    /**
     * Setter method for consumerName.
     *
     * @param aConsumerName the new value for consumerName
     */
    void setConsumerName(String aConsumerName);

    /**
     * Access method for isCashless.
     *
     * @return the current value of isCashless
     */
    Boolean getIsCashless();

    /**
     * Setter method for isCashless.
     *
     * @param aIsCashless the new value for isCashless
     */
    void setIsCashless(Boolean aIsCashless);

    /**
     * Access method for isMultiVend.
     *
     * @return the current value of isMultiVend
     */
    Boolean getIsMultiVend();

    /**
     * Setter method for isMultiVend.
     *
     * @param aIsMultiVend the new value for isMultiVend
     */
    void setIsMultiVend(Boolean aIsMultiVend);

    /**
     * Access method for currency.
     *
     * @return the current value of currency
     */
    String getCurrency();

    /**
     * Setter method for currency.
     *
     * @param aCurrency the new value for currency
     */
    void setCurrency(String aCurrency);

    /**
     * Access method for amount.
     *
     * @return the current value of amount
     */
    BigDecimal getAmount();

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    void setAmount(BigDecimal aAmount);

    /**
     * Access method for paidAmount.
     *
     * @return the current value of paidAmount
     */
    BigDecimal getPaidAmount();

    BigDecimal addPaidAmount(BigDecimal aPaidAmount);

    /**
     * Setter method for paidAmount.
     *
     * @param aPaidAmount the new value for paidAmount
     */
    void setPaidAmount(BigDecimal aPaidAmount);

    /**
     * Access method for balanceAmount.
     *
     * @return the current value of balanceAmount
     */
    BigDecimal getBalanceAmount();

    /**
     * Access method for latitude.
     *
     * @return the current value of latitude
     */
    String getLatitude();

    /**
     * Setter method for latitude.
     *
     * @param aLatitude the new value for latitude
     */
    void setLatitude(String aLatitude);

    /**
     * Access method for longitude.
     *
     * @return the current value of longitude
     */
    String getLongitude();

    /**
     * Setter method for longitude.
     *
     * @param aLongitude the new value for longitude
     */
    void setLongitude(String aLongitude);

    /**
     * Access method for statusId.
     *
     * @return the current value of statusId
     */
    Integer getStatusId();

    /**
     * Setter method for statusId.
     *
     * @param aStatusId the new value for statusId
     */
    void setStatusId(Integer aStatusId);

    /**
     * Access method for paymentStatusId.
     *
     * @return the current value of paymentStatusId
     */
    Integer getPaymentStatusId();

    /**
     * Setter method for paymentStatusId.
     *
     * @param aPaymentStatusId the new value for paymentStatusId
     */
    void setPaymentStatusId(Integer aPaymentStatusId);

    /**
     * Access method for remarks.
     *
     * @return the current value of remarks
     */
    String getRemarks();

    /**
     * Setter method for remarks.
     *
     * @param aRemarks the new value for remarks
     */
    void setRemarks(String aRemarks);

    /**
     * Access method for createdOn.
     *
     * @return the current value of createdOn
     */
    ZonedDateTime getCreatedOn();

    /**
     * Setter method for createdOn.
     *
     * @param aCreatedOn the new value for createdOn
     */
    void setCreatedOn(ZonedDateTime aCreatedOn);

    /**
     * Access method for modifiedOn.
     *
     * @return the current value of modifiedOn
     */
    ZonedDateTime getModifiedOn();

    /**
     * Setter method for modifiedOn.
     *
     * @param aModifiedOn the new value for modifiedOn
     */
    void setModifiedOn(ZonedDateTime aModifiedOn);

    /**
     * Access method for isPartialPayment.
     *
     * @return the current value of isPartialPayment
     */
    Boolean getIsPartialPayment();

    /**
     * Access method for machineUid.
     *
     * @return the current value of machineUid
     */
    String getMachineUid();

    /**
     * Setter method for machineUid.
     *
     * @param aMachineUid the new value for machineUid
     */
    void setMachineUid(String aMachineUid);

    /**
     * Access method for statusMessage.
     *
     * @return the current value of statusMessage
     */
    String getStatusMessage();

    /**
     * Setter method for statusMessage.
     *
     * @param aStatusMessage the new value for statusMessage
     */
    void setStatusMessage(String aStatusMessage);

    /**
     * Access method for actualAmount.
     *
     * @return the current value of actualAmount
     */
    BigDecimal getActualAmount();

    /**
     * Setter method for actualAmount.
     *
     * @param aActualAmount the new value for actualAmount
     */
    void setActualAmount(BigDecimal aActualAmount);

    /**
     * Access method for item.
     *
     * @return the current value of item
     */
    String getItem();

    /**
     * Setter method for item.
     *
     * @param aItem the new value for item
     */
    void setItem(String aItem);

    /**
     * Access method for discountAmount.
     *
     * @return the current value of discountAmount
     */
    BigDecimal getDiscountAmount();

    /**
     * Setter method for discountAmount.
     *
     * @param aDiscountAmount the new value for discountAmount
     */
    void setDiscountAmount(BigDecimal aDiscountAmount);

    /**
     * Access method for netAmount.
     *
     * @return the current value of netAmount
     */
    BigDecimal getNetAmount();

    /**
     * Setter method for netAmount.
     *
     * @param aNetAmount the new value for netAmount
     */
    void setNetAmount(BigDecimal aNetAmount);

    /**
     * Access method for country.
     *
     * @return the current value of country
     */
    String getCountry();

    /**
     * Setter method for country.
     *
     * @param aCountry the new value for country
     */
    void setCountry(String aCountry);

    /**
     * Access method for state.
     *
     * @return the current value of state
     */
    String getState();

    /**
     * Setter method for state.
     *
     * @param aState the new value for state
     */
    void setState(String aState);

    /**
     * Access method for city.
     *
     * @return the current value of city
     */
    String getCity();

    /**
     * Setter method for city.
     *
     * @param aCity the new value for city
     */
    void setCity(String aCity);

    /**
     * Access method for aggregator.
     *
     * @return the current value of aggregator
     */
    String getAggregator();

    /**
     * Setter method for aggregator.
     *
     * @param aAggregator the new value for aggregator
     */
    void setAggregator(String aAggregator);

    /**
     * Access method for vertical.
     *
     * @return the current value of vertical
     */
    String getVertical();

    /**
     * Setter method for vertical.
     *
     * @param aVertical the new value for vertical
     */
    void setVertical(String aVertical);

    /**
     * Access method for segment.
     *
     * @return the current value of segment
     */
    String getSegment();

    /**
     * Setter method for segment.
     *
     * @param aSegment the new value for segment
     */
    void setSegment(String aSegment);

    /**
     * Access method for commercialType.
     *
     * @return the current value of commercialType
     */
    String getCommercialType();

    /**
     * Setter method for commercialType.
     *
     * @param aCommercialType the new value for commercialType
     */
    void setCommercialType(String aCommercialType);

    /**
     * Access method for margin.
     *
     * @return the current value of margin
     */
    BigDecimal getMargin();

    /**
     * Setter method for margin.
     *
     * @param aMargin the new value for margin
     */
    void setMargin(BigDecimal aMargin);

    /**
     * Access method for vendStatus.
     *
     * @return the current value of vendStatus
     */
    String getVendStatus();

    /**
     * Setter method for vendStatus.
     *
     * @param aVendStatus the new value for vendStatus
     */
    void setVendStatus(String aVendStatus);

    /**
     * Access method for donationAmount.
     *
     * @return the current value of donationAmount
     */
    Integer getDonationAmount();

    /**
     * Setter method for donationAmount.
     *
     * @param aDonationAmount the new value for donationAmount
     */
    void setDonationAmount(Integer aDonationAmount);

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    Map<String, Object> getPrimaryKey();

}