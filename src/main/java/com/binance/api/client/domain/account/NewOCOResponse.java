package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOCOResponse extends OrderList {

    private List<OrderReport> orderReports;

    public List<OrderReport> getOrderReports() {
        return orderReports;
    }

    public void setOrderReports(List<OrderReport> orderReports) {
        this.orderReports = orderReports;
    }

}