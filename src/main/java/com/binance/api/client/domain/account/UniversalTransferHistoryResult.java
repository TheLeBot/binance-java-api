package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties
public class UniversalTransferHistoryResult {
    @JsonProperty("total")
    private long total;
    @JsonProperty("rows")
    private UniversalTransferHistoryItem[] rows;

    /**
     * Returns total received rows
     *
     * @return long
     */
    public long getTotalRows() { return this.total; }

    /**
     * Returns array of UniversalTransferHistoryItems
     *
     * @return UniversalTransferHistoryItem[]
     */
    public UniversalTransferHistoryItem[] getRows() { return this.rows; }

    @Override
    public String toString() {
        return "UniversalTransferHistoryResult [total=" + total + ",  rows=" + Arrays.toString(this.rows) + "]";
    }
}
