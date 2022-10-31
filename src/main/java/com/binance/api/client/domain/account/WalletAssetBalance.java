package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset balance in an Account.
 *
 * @see Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletAssetBalance {

    /**
     * Asset symbol.
     */
    private String asset;

    /**
     * Available balance.
     */
    private String free;

    /**
     * Locked by open orders.
     */
    private String locked;

    /**
     * Status 1 if in withdrawing
     */
    private String withdrawing;

    /**
     * Status 1 if can be IPO
     */
    private String ipoable;

    /**
     * Status 1 if can be valuated in BTC
     */
    private String btcValuation;

    /**
     * Freezed.
     */
    private String freeze;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }

    public String getWithdrawing() { return this.withdrawing; }

    public void setWithdrawing(String psValue) { this.withdrawing = psValue; }

    public String getIpoable() { return this.ipoable; }

    public void setIpoable(String psValue) { this.ipoable = psValue; }

    public String getBtcValuation() { return this.btcValuation; }

    public void setBtcValuation(String psValue) { this.btcValuation = psValue; }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("free", free)
                .append("locked", locked)
                .append("freeze", freeze)
                .append("withdrawing", withdrawing)
                .append("ipoable", ipoable)
                .append("btcValuation", btcValuation)
                .toString();
    }
}
