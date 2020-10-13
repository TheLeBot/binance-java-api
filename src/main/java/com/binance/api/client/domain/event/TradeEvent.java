package com.binance.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeEvent {

    @JsonProperty("e")
    String eventType;
    @JsonProperty("s")
    String symbol;
    @JsonProperty("t")
    String tradeId;
    @JsonProperty("p")
    String price;
    @JsonProperty("q")
    String quantity;
    @JsonProperty("b")
    String buyerOrderId;
    @JsonProperty("a")
    String sellerOrderId;
    @JsonProperty("T")
    long tradeTime;

    /**
     * <code>true</code> is red (a sell) and <code>false</code> is green.
     */
    @JsonProperty("m")
    boolean marketMaker;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(String buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public void setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }

    public long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public boolean isMarketMaker() {
        return marketMaker;
    }

    public void setMarketMaker(boolean marketMaker) {
        this.marketMaker = marketMaker;
    }

    @Override
    public String toString() {
        return "TradeEvent [symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + ", tradeTime=" + tradeTime + ", marketMaker="
                + marketMaker + "]";
    }

}