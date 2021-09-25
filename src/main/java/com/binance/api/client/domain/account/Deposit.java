package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A deposit that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {

  /**
   * Amount deposited.
   */
  private String amount;

  /**
   * Symbol
   */
  private String coin;

  /**
   * Network
   */
  private String network;

  /**
   * Status of deposit (0:pending,6: credited but cannot withdraw, 1:success)
   */
  private int status;

  /**
   * Deposit address.
   */
  private String address;

  /**
   * Deposit address tag (memo).
   */
  private String addressTag;

  /**
   * Transaction id
   */
  private String txId;

  /**
   * Deposit time.
   */
  private long insertTime;

  /**
   * Transfer type
   */
  private int transferType;

  /**
   * Confirm times for unlocking
   */
  private String unlockConfirm;

  /**
   * Confirm times
   */
  private String confirmTimes;

  /**
   * Returns deposit amount
   *
   * @return String
   */
  public String getAmount() { return amount; }

  /**
   * Sets deposit amount value
   *
   * @param amount Value to set
   */
  public void setAmount(String amount) { this.amount = amount; }

  /**
   * Returns symbol of deposit
   *
   * @return String
   */
  public String getCoin() { return this.coin; }

  /**
   * Sets symbol of deposit value
   *
   * @param coin Value to set
   */
  public void setCoin(String coin) { this.coin = coin; }

  /**
   * Returns deposit network
   *
   * @return String
   */
  public String getNetwork() { return this.network; }

  /**
   * Sets deposit network value
   *
   * @param network Value to set
   */
  public void setNetwork(String network) { this.network = network; }

  /**
   * Returns status of deposit
   *
   * @return int
   */
  public int getStatus() { return status; }

  /**
   * Sets status of deposit value
   *
   * @param status Value to set
   */
  public void setStatus(int status) { this.status = status; }

  /**
   * Returns deposit address
   *
   * @return String
   */
  public String getAddress() { return address; }

  /**
   * Sets deposit address
   *
   * @param address Address to set
   */
  public void setAddress(String address) { this.address = address; }

  /**
   * Returns deposit address tag
   *
   * @return String
   */
  public String getAddressTag() { return addressTag; }

  /**
   * Sets deposit address tag
   *
   * @param addressTag Address tag to set
   */
  public void setAddressTag(String addressTag) { this.addressTag = addressTag; }

  /**
   * Returns transaction id for current deposit
   *
   * @return String
   */
  public String getTxId() { return txId; }

  /**
   * Sets transaction id for current deposit
   *
   * @param txId Value to set
   */
  public void setTxId(String txId) { this.txId = txId; }


  /**
   * Returns insert time of deposit
   *
   * @return long
   */
  public long getInsertTime() { return insertTime; }

  /**
   * Sets insert time of deposit
   *
   * @param insertTime Value to set
   */
  public void setInsertTime(long insertTime) { this.insertTime = insertTime; }

  /**
   * Returns transfer type  1 for internal transfer, 0 for external transfer
   *
   * @return int
   */
  public int getTransferType() { return this.transferType; }

  /**
   * Sets transfer type value
   *
   * @param transferType Value to set
   */
  public void setTransferType(int transferType) { this.transferType = transferType; }

  /**
   * Returns unlock confirmations for current deposit
   *
   * @return String
   */
  public String getUnlockConfirm() { return this.unlockConfirm; }

  /**
   * Sets unlock confirmations value for current deposit
   *
   * @param unlockConfirm Value to set
   */
  public void setUnlockConfirm(String unlockConfirm) { this.unlockConfirm = unlockConfirm; }

  /**
   * Return trade confirmations times for deposit
   *
   * @return String
   */
  public String getConfirmTimes() { return this.confirmTimes; }

  /**
   * Sets confirm times value for current deposit
   *
   * @param confirmTimes Value to set
   */
  public void setConfirmTimes(String confirmTimes) { this.confirmTimes = confirmTimes; }

  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
            .append("amount", amount)
            .append("coin", coin)
            .append("network", network)
            .append("status", status)
            .append("address", address)
            .append("addressTag", addressTag)
            .append("txId", txId)
            .append("insertTime", insertTime)
            .append("transferType", transferType)
            .append("unlockConfirm", unlockConfirm)
            .append("confirmTimes", confirmTimes)
            .toString();
  }

}
