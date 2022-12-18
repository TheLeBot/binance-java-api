package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.UniversalTransferType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties
public class UniversalTransferHistoryItem {

    @JsonProperty("asset")
    private String asset;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tranId")
    private long tranId;
    @JsonProperty("timestamp")
    private long timestamp;

    public String getAsset() {return this.asset;}
    public String getAmount() {return this.amount;}
    public UniversalTransferType getTransferType() {return UniversalTransferType.valueOf(this.type);}
    public String getStatus() {return this.status;}
    public long getTransferId() {return  this.tranId;}
    public long getTransferTime() {return this.timestamp;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("amount", amount)
                .append("type", type)
                .append("status", status)
                .append("tranId", tranId)
                .append("timestamp", timestamp)
                .toString();
    }
}
