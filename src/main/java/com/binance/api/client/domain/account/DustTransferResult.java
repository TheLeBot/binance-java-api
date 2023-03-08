package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties
public class DustTransferResult {

    @JsonProperty("totalServiceCharge")
    private String totalServiceCharge;
    @JsonProperty("totalTransfered")
    private String totalTransfered;
    @JsonProperty("transferResult")
    private DustTransferItem[] transferResult;

    /**
     * Returns total charged for dust transfer in BNB
     *
     * @return String
     */
    public String getTotalServiceCharge() { return this.totalServiceCharge; }

    /**
     * Returns total transfered into BNB in BNB
     *
     * @return String
     */
    public String getTotalTransfered() { return this.totalTransfered; }

    /**
     * Returns array of DustTransferItem
     *
     * @return DustTransferItem[]
     */
    public DustTransferItem[] getTransferResult() { return this.transferResult; }

    @Override
    public String toString() {
        return "DustTransferResult [totalTransfered=" + getTotalTransfered() + ", serviceCharged=" + getTotalServiceCharge() +", result=" + Arrays.toString(getTransferResult()) + "]";
    }
}
