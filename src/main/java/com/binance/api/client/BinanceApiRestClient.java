package com.binance.api.client;

import com.binance.api.client.domain.UniversalTransferType;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.*;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;

import java.util.List;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiRestClient {

  // General endpoints

  /**
   * Test connectivity to the Rest API.
   */
  void ping();

  /**
   * Test connectivity to the Rest API and get the current server time.
   *
   * @return current server time.
   */
  Long getServerTime();

  /**
   * @return Current exchange trading rules and symbol information
   */
  ExchangeInfo getExchangeInfo();

  /**
   * @return All the supported assets and whether or not they can be withdrawn.
   */
  List<Asset> getAllAssets();

  // Market Data endpoints

  /**
   * Get order book of a symbol.
   *
   * @param symbol ticker symbol (e.g. ETHBTC)
   * @param limit depth of the order book (max 100)
   */
  OrderBook getOrderBook(String symbol, Integer limit);

  /**
   * Get recent trades (up to last 500). Weight: 1
   *
   * @param symbol ticker symbol (e.g. ETHBTC)
   * @param limit of last trades (Default 500; max 1000.)
   */
  List<TradeHistoryItem> getTrades(String symbol, Integer limit);

  /**
   * Get older trades. Weight: 5
   *
   * @param symbol ticker symbol (e.g. ETHBTC)
   * @param limit of last trades (Default 500; max 1000.)
   * @param fromId TradeId to fetch from. Default gets most recent trades.
   */
  List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId);

  /**
   * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with
   * the same price will have the quantity aggregated.
   *
   * If both <code>startTime</code> and <code>endTime</code> are sent, <code>limit</code>should not
   * be sent AND the distance between <code>startTime</code> and <code>endTime</code> must be less than 24 hours.
   *
   * @param symbol symbol to aggregate (mandatory)
   * @param fromId ID to get aggregate trades from INCLUSIVE (optional)
   * @param limit Default 500; max 1000 (optional)
   * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE (optional).
   * @param endTime Timestamp in ms to get aggregate trades until INCLUSIVE (optional).
   * @return a list of aggregate trades for the given symbol
   */
  List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime);

  /**
   * Return the most recent aggregate trades for <code>symbol</code>
   *
   * @see #getAggTrades(String, String, Integer, Long, Long)
   */
  List<AggTrade> getAggTrades(String symbol);

  /**
   * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
   *
   * @param symbol symbol to aggregate (mandatory)
   * @param interval candlestick interval (mandatory)
   * @param limit Default 500; max 1000 (optional)
   * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
   * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
   * @return a candlestick bar for the given symbol and interval
   */
  List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime);

  /**
   * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
   *
   * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
   */
  List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval);

  /**
   * Get 24 hour price change statistics.
   *
   * @param symbol ticker symbol (e.g. ETHBTC)
   */
  TickerStatistics get24HrPriceStatistics(String symbol);

  /**
   * Get 24 hour price change statistics for all symbols.
   */
  List<TickerStatistics> getAll24HrPriceStatistics();

  /**
   * Get Latest price for all symbols.
   */
  List<TickerPrice> getAllPrices();

  /**
   * Get latest price for <code>symbol</code>.
   *
   * @param symbol ticker symbol (e.g. ETHBTC)
   */
  TickerPrice getPrice(String symbol);

  /**
   * Get best price/qty on the order book for all symbols.
   */
  List<BookTicker> getBookTickers();

  // Account endpoints

  /**
   * Send in a new order.
   *
   * @param order the new order to submit.
   * @return a response containing details about the newly placed order.
   */
  NewOrderResponse newOrder(NewOrder order);

  /**
   * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
   *
   * @param order the new TEST order to submit.
   */
  void newOrderTest(NewOrder order);

  /**
   * Check an order's status.
   * @param orderStatusRequest order status request options/filters
   *
   * @return an order
   */
  Order getOrderStatus(OrderStatusRequest orderStatusRequest);

  /**
   * Cancel an active order.
   *
   * @param cancelOrderRequest order status request parameters
   */
  CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

  /**
   * Get all open orders on a symbol.
   *
   * @param orderRequest order request parameters
   * @return a list of all account open orders on a symbol.
   */
  List<Order> getOpenOrders(OrderRequest orderRequest);

  /**
   * Get all account orders; active, canceled, or filled.
   *
   * @param orderRequest order request parameters
   * @return a list of all account orders
   */
  List<Order> getAllOrders(AllOrdersRequest orderRequest);

  /**
   * Send in a new OCO order.
   *
   * @param order the new order to submit.
   * @return a response containing details about the newly placed order.
   */
  OcoOrderResponse newOcoOrder(NewOrder order);

  /**
   * Check an OCO order's status. Note that binance will not return order leg
   * details in this call (orderReports will be null). You will need to use
   * individual leg ids and {@link #getOrderStatus(OrderStatusRequest)} to get
   * details about individual legs.
   *
   * @param statusRequest status request object
   * @return an order
   */
  OcoOrderResponse getOcoOrderStatus(OcoOrderStatusRequest statusRequest);

  /**
   * Cancel an active OCO order. Both legs will be cancelled.
   * @param cancelOrderRequest order request parameters
   * @return order execution status
   */
  OcoOrderResponse cancelOcoOrder(CancelOrderRequest cancelOrderRequest);

  /**
   * Get current account information.
   */
  Account getAccount(Long recvWindow, Long timestamp);

  /**
   * Get current account information using default parameters.
   */
  Account getAccount();

  /**
   * Get a list of current funding account balances (>0)
   *
   * @return List<WalletAssetBalance>
   */
  List<WalletAssetBalance> getFundingBalances();

  /**
   * Get a list of current spot account balances (>0)
   *
   * @return List<WalletAssetBalance>
   */
  List<WalletAssetBalance> getSpotBalances();

  /**
   * Get trades for a specific account and symbol.
   *
   * @param symbol symbol to get trades from
   * @param limit default 500; max 1000
   * @param fromId TradeId to fetch from. Default gets most recent trades.
   * @return a list of trades
   */
  List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp);

  /**
   * Get trades for a specific account and symbol.
   *
   * @param symbol symbol to get trades from
   * @param limit default 500; max 1000
   * @return a list of trades
   */
  List<Trade> getMyTrades(String symbol, Integer limit);

  /**
   * Get trades for a specific account and symbol.
   *
   * @param symbol symbol to get trades from
   * @return a list of trades
   */
  List<Trade> getMyTrades(String symbol);

  /**
   * Submit a withdraw request.
   *
   * Enable Withdrawals option has to be active in the API settings.
   *
   * @param asset asset symbol to withdraw
   * @param address address to withdraw to
   * @param amount amount to withdraw
   * @param name description/alias of the address
   * @param addressTag Secondary address identifier for coins like XRP,XMR etc.
   * @param withdrawOrderId client customize id for withdraw order
   * @param network the transfer network
   * @param transactionFeeFlag When making internal transfer, true for returning the fee to the destination account; false for returning the fee back to the departure account. Default false.
   */
  WithdrawResult withdraw(String asset, String address, String amount, String name, String addressTag, String withdrawOrderId, String network, Boolean transactionFeeFlag);


  /**
   * Fetch account deposit history.
   *
   * @return deposit history, containing a list of deposits
   */
  List<Deposit> getDepositHistory();

  /**
   * Fetch account deposit history.
   *
   * @param coin Symbol to work with
   *
   * @return deposit history, containing a list of deposits
   */
  List<Deposit> getDepositHistory(String coin);

  /**
   * Fetch account deposit history.
   *
   * @return deposit history, containing a list of deposits
   */
  List<Deposit> getDepositHistory(String coin, int status, Long startTime, Long endTime,
                                  int offset, int limit);

  /**
   * Fetch account withdraw history.
   *
   * @return withdraw history, containing a list of withdrawals
   */
  List<Withdraw> getWithdrawHistory();

  /**
   * Fetch account withdraw history.
   *
   * @param coin Symbol to work with
   *
   * @return withdraw history, containing a list of withdrawals
   */
  List<Withdraw> getWithdrawHistory(String coin);

  /**
   * Fetch account withdraw history.
   *
   * @param coin Symbol
   * @param withdrawOrderId Withdraw order id if any
   * @param status Status
   * @param startTime Default: 90 days from current timestamp
   * @param endTime  Default: current timestamp
   * @param offset Number of days as offset to start getting
   * @param limit Default 1000, max 1000
   * @return List<Withdraw> withdraw history, containing a list of withdrawals
   */
  List<Withdraw> getWithdrawHistory(String coin, String withdrawOrderId, int status, Long startTime, Long endTime, int offset, int limit);

  /**
   * Fetch deposit address.
   *
   * @return deposit address for a given asset.
   */
  DepositAddress getDepositAddress(String asset, String network);

  // User stream endpoints

  /**
   * Start a new user data stream.
   *
   * @return a listen key that can be used with data streams
   */
  String startUserDataStream();

  /**
   * PING a user data stream to prevent a time out.
   *
   * @param listenKey listen key that identifies a data stream
   */
  void keepAliveUserDataStream(String listenKey);

  /**
   * Executes a universal coin transfer within accounts on the client
   *
   * @param type UniversalTransferType Type of transfer
   * @param asset Coin to transfer
   * @param amount Amount to transfer
   * @param fromSymbol Symbol to transfer from (must be sent when type are ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN)
   * @param toSymbol Symbol to transfer to (must be sent when type are MARGIN_ISOLATEDMARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN)
   *
   * @return UniversalTransferResult
   */
  UniversalTransferResult universalTransfer(UniversalTransferType type, String asset, String amount, String fromSymbol, String toSymbol);

  /**
   * Executes a universal coin transfer within accounts on the client
   *
   * @param type UniversalTransferType Type of transfer
   * @param asset Coin to transfer
   * @param amount Amount to transfer
   *
   * @return UniversalTransferResult
   */
  UniversalTransferResult universalTransfer(UniversalTransferType type, String asset, String amount);

  /**
   * Returns a list of universal transfer history objects as a result wrapper
   *
   * @param type UniversalTransferType Type of transfer
   * @param size Maximum number of records to fetch
   * @param startTime Start time from which to fetch
   * @param endTime End time till which to fetch
   * @param fromSymbol Symbol to transfer from (must be sent when type are ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN)
   * @param toSymbol Symbol to transfer to (must be sent when type are MARGIN_ISOLATEDMARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN)
   *
   * @return UniversalTransferHistoryResult
   */
  UniversalTransferHistoryResult getAccountTransferHistory(UniversalTransferType type, Integer size, Long startTime, Long endTime, String fromSymbol, String toSymbol);

  /**
   * Transfers dust assets into BNB and returns an DustTransferResult object
   *
   * @param asset Array of assets to transfer
   *
   * @return DustTransferResult
   */
  DustTransferResult transferDustToBNB(String[] asset);

  /**
   * Returns dust asset which can be converted as dust into BNB
   *
   * @return DustAssetResult
   */
  DustAssetResult getDustAssets();


  /**
   * Close out a new user data stream.
   *
   * @param listenKey listen key that identifies a data stream
   */
  void closeUserDataStream(String listenKey);
}
