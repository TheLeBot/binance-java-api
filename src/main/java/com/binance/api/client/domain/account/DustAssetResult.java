package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties
public class DustAssetResult {
    @JsonProperty("details")
    private DustAssetItem[] details;
    @JsonProperty("totalTransferBtc")
    private String totalTransferBtc;
    @JsonProperty("totalTransferBNB")
    private String totalTransferBNB;
    @JsonProperty("dribbletPercentage")
    private String dribbletPercentage;

    /**
     * Returns total transferred in BTC
     *
     * @return String
     */
    public String getTotalTransferBtc() { return this.totalTransferBtc; }

    /**
     * Returns total transferred in BNB
     *
     * @return String
     */
    public String getTotalTransferBNB() { return this.totalTransferBNB; }

    /**
     * Returns transfer commission in percent
     *
     * @return String
     */
    public String getDribbletPercentage() { return this.dribbletPercentage; }

    /**
     * Returns array of DustAssetItem
     *
     * @return DustAssetItem[]
     */
    public DustAssetItem[] getAssets() { return this.details; }

    @Override
    public String toString() {
        return "DustAssetResult [totalTransferBtc=" + getTotalTransferBtc() + ", totalTransferBNB=" + getTotalTransferBNB() +", dribbletPercentage=" + getDribbletPercentage() + ", details=" + Arrays.toString(getAssets()) + "]";
    }
}
