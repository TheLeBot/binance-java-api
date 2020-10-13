package com.binance.api.client.domain.event;

import java.util.Arrays;

import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.account.OcoLeg;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OcoTradeUpdateEvent {

    @JsonProperty("e")// "listStatus"
    private String eventType;

    @JsonProperty("E")
    private long eventTime;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("g")
    private int orderListId;

    @JsonProperty("c")
    private OrderType contingencyType;

    @JsonProperty("l")
    private String listStatusType;

    @JsonProperty("L")
    private String listOrderStatus;

    @JsonProperty("r")
    private String listRejectReason;

    @JsonProperty("C")
    private String listClientOrderId;

    @JsonProperty("T")
    private long transactionTime;

    @JsonProperty("O")
    private OcoLeg[] legs;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(int orderListId) {
        this.orderListId = orderListId;
    }

    public OrderType getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(OrderType contingencyType) {
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

    public String getListRejectReason() {
        return listRejectReason;
    }

    public void setListRejectReason(String listRejectReason) {
        this.listRejectReason = listRejectReason;
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

    public OcoLeg[] getLegs() {
        return legs;
    }

    public void setLegs(OcoLeg[] legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "OcoTradeUpdateEvent [eventType=" + eventType + ", eventTime=" + eventTime + ", symbol=" + symbol + ", orderListId="
                + orderListId + ", contingencyType=" + contingencyType + ", listStatusType=" + listStatusType + ", listOrderStatus="
                + listOrderStatus + ", listRejectReason=" + listRejectReason + ", listClientOrderId=" + listClientOrderId + ", transactionTime="
                + transactionTime + ", legs=" + Arrays.toString(legs) + "]";
    }


}