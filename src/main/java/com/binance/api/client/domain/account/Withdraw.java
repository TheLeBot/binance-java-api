package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A withdraw that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdraw {

  /**
   * Destination address.
   */
  private String address;

  /**
   * Amount withdrawn.
   */
  private String amount;

  /**
   * Apply time
   */
  private String applyTime;

  /**
   * Symbol
   */
  private String coin;

  /**
   * Id.
   */
  private String id;

  /**
   * Client withdraw order id
   */
  private String withdrawOrderId;

  /**
   * Network
   */
  private String network;

  /**
   * Transfer type
   */
  private int transferType;

  /**
   * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
   */
  private int status;

  /**
   * Fee amount of transaction
   */
  private String transactionFee;

  /**
   * Count of confirmations
   */
  private int confirmNo;


  /**
   * Transaction id.
   */
  private String txId;

  /**
   * Returns withdraw address
   *
   * @return String
   */
  public String getAddress() { return address; }

  /**
   * Sets withdraw address
   *
   * @param address Address to set
   */
  public void setAddress(String address) { this.address = address; }

  /**
   * Returns withdraw amount
   *
   * @return String
   */
  public String getAmount() { return amount; }

  /**
   * Sets withdraw amount value
   *
   * @param amount Value to set
   */
  public void setAmount(String amount) { this.amount = amount; }

  /**
   * Returns withdraw apply time
   *
   * @return String
   */
  public String getApplyTime() { return applyTime; }

  /**
   * Sets withdraw apply time value
   *
   * @param applyTime Value to set
   */
  public void setApplyTime(String applyTime) { this.applyTime = applyTime; }

  /**
   * Returns symbol of withdraw
   *
   * @return String
   */
  public String getCoin() { return this.coin; }

  /**
   * Sets symbol of withdraw value
   *
   * @param coin Value to set
   */
  public void setCoin(String coin) { this.coin = coin; }

  /**
   * Returns withdraw id
   *
   * @return String
   */
  public String getId() { return id; }

  /**
   * Sets withdraw id value
   *
   * @param id Value to set
   */
  public void setId(String id) { this.id = id; }

  /**
   * Returns withdraw order id if set
   *
   * @return String
   */
  public String getWithdrawOrderId() { return this.withdrawOrderId; }

  /**
   * Sets withdraw order id value
   *
   * @param withdrawOrderId Value to set
   */
  public void setWithdrawOrderId(String withdrawOrderId) { this.withdrawOrderId = withdrawOrderId; }

  /**
   * Returns withdraw network
   *
   * @return String
   */
  public String getNetwork() { return this.network; }

  /**
   * Sets withdraw network value
   *
   * @param network Value to set
   */
  public void setNetwork(String network) { this.network = network; }

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
   * Returns status of withdraw
   *
   * @return int
   */
  public int getStatus() { return status; }

  /**
   * Sets status of withdraw value
   *
   * @param status Value to set
   */
  public void setStatus(int status) { this.status = status; }

  /**
   * Returns transaction fee value as String
   *
   * @return String
   */
  public String getTransactionFee() { return this.transactionFee; }

  /**
   * Sets transaction fee value
   *
   * @param transactionFee Value to set
   */
  public void setTransactionFee(String transactionFee) { this.transactionFee = transactionFee; }

  /**
   * Returns number of confirmations
   *
   * @return int
   */
  public int getConfirmNo() { return this.confirmNo; }

  /**
   * Sets confirmation count value
   *
   * @param confirmNo Value to set
   */
  public void setConfirmNo(int confirmNo) { this.confirmNo = confirmNo; }

  /**
   * Returns transaction id for current withdraw
   *
   * @return String
   */
  public String getTxId() { return txId; }

  /**
   * Sets transaction id for current withdraw
   *
   * @param txId Value to set
   */
  public void setTxId(String txId) { this.txId = txId; }

  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
            .append("address", address)
            .append("amount", amount)
            .append("applyTime", applyTime)
            .append("coin", coin)
            .append("id", id)
            .append("withdrawOrderId", withdrawOrderId)
            .append("network", network)
            .append("transferType", transferType)
            .append("status", status)
            .append("transactionFee", transactionFee)
            .append("confirmNo", confirmNo)
            .append("txId", txId)
            .toString();
  }

}
