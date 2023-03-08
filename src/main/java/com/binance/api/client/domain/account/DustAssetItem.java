package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties
public class DustAssetItem {

    @JsonProperty("asset")
    private String asset;
    @JsonProperty("assetFullName")
    private String assetFullName;
    @JsonProperty("amountFree")
    private String amountFree;
    @JsonProperty("toBTC")
    private String toBTC;
    @JsonProperty("toBNB")
    private String toBNB;
    @JsonProperty("toBNBOffExchange")
    private String toBNBOffExchange;
    @JsonProperty("exchange")
    private String exchange;

    public String getAsset() {return this.asset;}
    public String getAssetFullName() {return this.assetFullName;}
    public String getAmountFree() {return this.amountFree;}
    public String getToBTC() {return this.toBTC;}
    public String getToBNB() {return  this.toBNB;}
    public String getToBNBOffExchange() {return this.toBNBOffExchange;}
    public String getExchange() {return this.exchange;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", getAsset())
                .append("assetFullName", getAssetFullName())
                .append("amountFree", getAmountFree())
                .append("toBTC", getToBTC())
                .append("toBNB", getToBNB())
                .append("toBNBOffExchange", getToBNBOffExchange())
                .append("exchange", getExchange())
                .toString();
    }
}
