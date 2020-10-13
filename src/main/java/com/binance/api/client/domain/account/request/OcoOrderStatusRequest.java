package com.binance.api.client.domain.account.request;

import com.binance.api.client.constant.BinanceApiConstants;

public class OcoOrderStatusRequest {

    Long orderListId;

    String origClientOrderId;

    Long recvWindow;

    Long timestamp;

    public OcoOrderStatusRequest(String origClientOrderId) {
        this();
        this.origClientOrderId = origClientOrderId;
    }

    public OcoOrderStatusRequest(Long orderId) {
        this();
        orderListId = orderId;
    }

    private OcoOrderStatusRequest() {
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public void setOrigClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
    }

    public Long getRecvWindow() {
        return recvWindow;
    }

    public void setRecvWindow(Long recvWindow) {
        this.recvWindow = recvWindow;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "OcoOrderStatusRequest [orderListId=" + orderListId + ", origClientOrderId=" + origClientOrderId + ", recvWindow=" + recvWindow
                + ", timestamp=" + timestamp + "]";
    }

}