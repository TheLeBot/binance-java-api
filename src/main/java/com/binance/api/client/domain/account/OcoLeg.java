package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OcoLeg {

    @JsonAlias({"s", "symbol"})
    String symbol;
    @JsonAlias({"i", "orderId"})
    long orderId;
    @JsonAlias({"c", "clientOrderId"})
    String clientOrderId;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    @Override
    public String toString() {
        return "OcoLeg [symbol=" + symbol + ", orderId=" + orderId + ", clientOrderId=" + clientOrderId + "]";
    }

}