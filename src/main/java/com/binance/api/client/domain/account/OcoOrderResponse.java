package com.binance.api.client.domain.account;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Response returned when a new OCO order is placed.
 *
 * @author sergey
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OcoOrderResponse {

    long orderListId;
    String contingencyType;
    String listStatusType;
    String listOrderStatus;
    String listClientOrderId;
    long transactionTime;
    String symbol;
    OcoLeg[] orders;
    Order[] orderReports;

    public long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(long orderListId) {
        this.orderListId = orderListId;
    }

    public String getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
    }

    public String getListStatusType() {
        return listStatusType;
    }

    public void setListStatusType(String listStatusType) {
        this.listStatusType = listStatusType;
    }

    public String getListOrderStatus() {
        return listOrderStatus;
    }

    public void setListOrderStatus(String listOrderStatus) {
        this.listOrderStatus = listOrderStatus;
    }

    public String getListClientOrderId() {
        return listClientOrderId;
    }

    public void setListClientOrderId(String listClientOrderId) {
        this.listClientOrderId = listClientOrderId;
    }

    public long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(long transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OcoLeg[] getOrders() {
        return orders;
    }

    public void setOrders(OcoLeg[] orders) {
        this.orders = orders;
    }

    public Order[] getOrderReports() {
        return orderReports;
    }

    public void setOrderReports(Order[] orderReports) {
        this.orderReports = orderReports;
    }

    @Override
    public String toString() {
        return "OcoOrderResponse [orderListId=" + orderListId + ", contingencyType=" + contingencyType + ", listStatusType=" + listStatusType
                + ", listOrderStatus=" + listOrderStatus + ", listClientOrderId=" + listClientOrderId + ", transactionTime=" + transactionTime
                + ", symbol=" + symbol + ", orders=" + Arrays.toString(orders) + ", orderReports=" + Arrays.toString(orderReports) + "]";
    }

}