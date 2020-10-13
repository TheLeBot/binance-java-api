package com.binance.api.client.domain.account;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A trade order to enter or exit a position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrder {

  /**
   * Symbol to place the order on.
   */
  private String symbol;

  /**
   * Buy/Sell order side.
   */
  private OrderSide side;

  /**
   * Type of order.
   */
  private OrderType type;

  /**
   * Time in force to indicate how long will the order remain active.
   */
  private TimeInForce timeInForce;

  /**
   * Quantity.
   */
  private String quantity;

  /**
   * Quote quantity.
   */
  private String quoteOrderQty;

  /**
   * Price.
   */
  private String price;

  /**
   * A unique id for the order. Automatically generated if not sent.
   */
  private String newClientOrderId;

  /**
   * Used with stop orders.
   */
  private String stopPrice;

  /**
   * Used with OCO orders.
   */
  private String stopLimitPrice;

  /**
   * Optional client id for limit leg in OCO order
   */
  private String limitClientOrderId;

  /**
   * Optional client id for stop leg in OCO order
   */
  private String stopClientOrderId;

  /**
   * Used with iceberg orders.
   */
  private String icebergQty;

  /**
   * Set the response JSON. ACK, RESULT, or FULL; default: RESULT.
   */
  private NewOrderResponseType newOrderRespType;

  /**
   * Receiving window.
   */
  private Long recvWindow;

  /**
   * Order timestamp.
   */
  private long timestamp;

  /**
   * Creates a new order with all required parameters.
   */
  public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity) {
    this.symbol = symbol;
    this.side = side;
    this.type = type;
    this.timeInForce = timeInForce;
    this.quantity = quantity;
    this.newOrderRespType = NewOrderResponseType.RESULT;
    this.timestamp = System.currentTimeMillis();
    this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
  }

  /**
   * Creates a new order with all required parameters plus price, which is optional for MARKET orders.
   */
  public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity, String price) {
    this(symbol, side, type, timeInForce, quantity);
    this.price = price;
  }

  public String getSymbol() {
    return symbol;
  }

  public NewOrder symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public OrderSide getSide() {
    return side;
  }

  public NewOrder side(OrderSide side) {
    this.side = side;
    return this;
  }

  public OrderType getType() {
    return type;
  }

  public NewOrder type(OrderType type) {
    this.type = type;
    return this;
  }

  public NewOrder stopLimitPrice(String price) {
    this.stopLimitPrice = price;
    return this;
  }

  public String getStopLimitPrice() {
    return this.stopLimitPrice;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public NewOrder timeInForce(TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
    return this;
  }

  public String getQuantity() {
    return quantity;
  }

  public NewOrder quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  public String getQuoteOrderQty() {
    return quoteOrderQty;
  }

  public NewOrder quoteOrderQty(String quoteOrderQty) {
    this.quoteOrderQty = quoteOrderQty;
    return this;
  }

  public String getPrice() {
    return price;
  }

  public NewOrder price(String price) {
    this.price = price;
    return this;
  }

  public String getNewClientOrderId() {
    return newClientOrderId;
  }

  public NewOrder newClientOrderId(String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
    return this;
  }

  public String getLimitClientOrderId() {
    return limitClientOrderId;
  }

  public NewOrder limitClientOrderId(String limitClientOrderId) {
    this.limitClientOrderId = limitClientOrderId;
    return this;
  }

  public String getStopClientOrderId() {
    return stopClientOrderId;
  }

  public NewOrder stopClientOrderId(String stopClientOrderId) {
    this.stopClientOrderId = stopClientOrderId;
    return this;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public NewOrder stopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
    return this;
  }

  public String getIcebergQty() {
    return icebergQty;
  }

  public NewOrder icebergQty(String icebergQty) {
    this.icebergQty = icebergQty;
    return this;
  }

  public NewOrderResponseType getNewOrderRespType() {
    return newOrderRespType;
  }

  public NewOrder newOrderRespType(NewOrderResponseType newOrderRespType) {
    this.newOrderRespType = newOrderRespType;
    return this;
  }

  public Long getRecvWindow() {
    return recvWindow;
  }

  public NewOrder recvWindow(Long recvWindow) {
    this.recvWindow = recvWindow;
    return this;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public NewOrder timestamp(long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Places a MARKET buy order for the given <code>quantity</code>.
   *
   * @return a new order which is pre-configured with MARKET as the order type and BUY as the order side.
   */
  public static NewOrder marketBuy(String symbol, String quantity) {
    return new NewOrder(symbol, OrderSide.BUY, OrderType.MARKET, null, quantity);
  }

  /**
   * Places a MARKET sell order for the given <code>quantity</code>.
   *
   * @return a new order which is pre-configured with MARKET as the order type and SELL as the order side.
   */
  public static NewOrder marketSell(String symbol, String quantity) {
    return new NewOrder(symbol, OrderSide.SELL, OrderType.MARKET, null, quantity);
  }

  /**
   * Places a LIMIT buy order for the given <code>quantity</code> and <code>price</code>.
   *
   * @return a new order which is pre-configured with LIMIT as the order type and BUY as the order side.
   */
  public static NewOrder limitBuy(String symbol, TimeInForce timeInForce, String quantity, String price) {
    return new NewOrder(symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price);
  }

  /**
   * Creates a One-Cancels-Other buy order. Note that when the stopPrice is
   * reached the exchange will execute a market buy up to the stopLimitPrice but
   * you will still be considered the market maker.
   *
   * @param symbol         the coin you want to buy
   * @param quantity       amount to buy
   * @param price          the limit order price (should be lower than the
   *                       stopPrice and current price)
   * @param stopPrice      higher price that triggers buying order at the
   *                       stopLimitPrice
   * @param stopLimitPrice the limit order price that will be put to the order
   *                       book when the stopPrice is reached.
   * @return the new order
   */
  public static NewOrder ocoBuy(String symbol, String quantity, String price, String stopPrice, String stopLimitPrice) {
    NewOrder buy = limitBuy(symbol, TimeInForce.GTC, quantity, price);
    buy.type(OrderType.OCO);
    buy.stopPrice(stopPrice);
    buy.stopLimitPrice(stopLimitPrice);
    return buy;
  }

  /**
   * Creates a One-Cancels-Other sell order. Note that when the stopPrice is
   * reached the exchange will execute a market sell at the stopLimitPrice but
   * you will still be considered the market maker.
   *
   * @param symbol         the coin you want to sell
   * @param quantity       amount to sell
   * @param price          the limit order price (should be higher than the
   *                       stopPrice and current price)
   * @param stopPrice      lower price that triggers buying order at the
   *                       stopLimitPrice
   * @param stopLimitPrice the limit order price that will be put to the order
   *                       book when the stopPrice is reached.
   * @return the new order
   */
  public static NewOrder ocoSell(String symbol, String quantity, String price, String stopPrice, String stopLimitPrice) {
    NewOrder sell = limitSell(symbol, TimeInForce.GTC, quantity, price);
    sell.type(OrderType.OCO);
    sell.stopPrice(stopPrice);
    sell.stopLimitPrice(stopLimitPrice);
    return sell;
  }

  /**
   * Places a LIMIT sell order for the given <code>quantity</code> and <code>price</code>.
   *
   * @return a new order which is pre-configured with LIMIT as the order type and SELL as the order side.
   */
  public static NewOrder limitSell(String symbol, TimeInForce timeInForce, String quantity, String price) {
    return new NewOrder(symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
            .append("symbol", symbol)
            .append("side", side)
            .append("type", type)
            .append("price", price)
            .append("stopLimitPrice", stopLimitPrice)
            .append("stopPrice", stopPrice)
            .append("quantity", quantity)
            .append("quoteOrderQty", quoteOrderQty)
            .append("newClientOrderId", newClientOrderId)
            .append("icebergQty", icebergQty)
            .append("newOrderRespType", newOrderRespType)
            .append("recvWindow", recvWindow)
            .append("timestamp", timestamp)
            .append("timeInForce", timeInForce)
            .toString();
  }
}