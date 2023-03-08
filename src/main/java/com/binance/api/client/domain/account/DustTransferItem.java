package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties
public class DustTransferItem {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("fromAsset")
    private String fromAsset;
    @JsonProperty("operateTime")
    private long operateTime;
    @JsonProperty("serviceChargeAmount")
    private String serviceChargeAmount;
    @JsonProperty("tranId")
    private long tranId;
    @JsonProperty("transferedAmount")
    private String transferedAmount;

    public String getAmount() {return this.amount;}
    public String getFromAsset() {return this.fromAsset;}
    public long getOperateTime() {return this.operateTime;}
    public String getServiceChargeAmount() {return this.serviceChargeAmount;}
    public long getTransactionId() {return  this.tranId;}
    public String getTransferedAmount() {return this.transferedAmount;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("amount", amount)
                .append("fromAsset", fromAsset)
                .append("operateTime", operateTime)
                .append("serviceChargeAmount", serviceChargeAmount)
                .append("tranId", tranId)
                .append("transferedAmount", transferedAmount)
                .toString();
    }
}
