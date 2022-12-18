package com.binance.api.client.impl;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.*;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

import java.util.List;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceApiService {

    // General endpoints

    @GET("/api/v1/ping")
    Call<Void> ping();

    @GET("/api/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/api/v1/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    @GET
    Call<List<Asset>> getAllAssets(@Url String url);

    // Market data endpoints

    @GET("/api/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/api/v1/trades")
    Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/api/v1/historicalTrades")
    Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId);

    @GET("/api/v1/aggTrades")
    Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/api/v1/klines")
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                               @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/api/v1/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/24hr")
    Call<List<TickerStatistics>> getAll24HrPriceStatistics();

    @GET("/api/v1/ticker/allPrices")
    Call<List<TickerPrice>> getLatestPrices();

    @GET("/api/v3/ticker/price")
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/allBookTickers")
    Call<List<BookTicker>> getBookTickers();

    // Account endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                    @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                                    @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                    @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                    @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrderQuoteQty(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                            @Query("timeInForce") TimeInForce timeInForce, @Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
                                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/oco")
    Call<OcoOrderResponse> newOcoOrder(@Query("symbol") String symbol,
                                       @Query("listClientOrderId") String listClientOrderId,
                                       @Query("side") OrderSide side,
                                       @Query("quantity") String quantity,
                                       @Query("limitClientOrderId") String limitClientOrderId,
                                       @Query("price") String price,
                                       @Query("limitIcebergQty") String icebergQty,
                                       @Query("stopClientOrderId") String stopClientOrderId,
                                       @Query("stopPrice") String stopPrice,
                                       @Query("stopLimitPrice") String stopLimitPrice,
                                       @Query("stopLimitTimeInForce") TimeInForce stopLimitTimeInForce,
                                       @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                       @Query("recvWindow") Long recvWindow,
                                       @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/oco/test")
    Call<Void> newOcoOrderTest(@Query("symbol") String symbol,
                               @Query("listClientOrderId") String listClientOrderId,
                               @Query("side") OrderSide side,
                               @Query("quantity") String quantity,
                               @Query("limitClientOrderId") String limitClientOrderId,
                               @Query("price") String price,
                               @Query("limitIcebergQty") String icebergQty,
                               @Query("stopClientOrderId") String stopClientOrderId,
                               @Query("stopPrice") String stopPrice,
                               @Query("stopLimitPrice") String stopLimitPrice,
                               @Query("stopLimitTimeInForce") TimeInForce stopLimitTimeInForce,
                               @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                               @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    Call<Void> newOrderTest(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                            @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/order")
    Call<Order> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                               @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/orderList")
    Call<OcoOrderResponse> getOcoOrderStatus(@Query("orderListId") Long orderListId, @Query("origClientOrderId") String origClientOrderId,
                                             @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/order")
    Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                          @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/orderList")
    Call<OcoOrderResponse> cancelOcoOrder(@Query("symbol") String symbol, @Query("orderListId") Long orderId,
                                          @Query("listClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrders")
    Call<List<Order>> getOpenOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                   @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    Call<Account> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/capital/withdraw/apply")
    Call<WithdrawResult> withdraw(@Query("coin") String coin,@Query("withdrawOrderId") String clientOrderId,
                                  @Query("network") String network, @Query("address") String address,
                                  @Query("addressTag") String addressTag, @Query("amount") String amount,
                                  @Query("transactionFeeFlag") Boolean feeFlag, @Query("name") String name,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/deposit/hisrec")
    Call<List<Deposit>> getDepositHistory(@Query("coin") String coin, @Query("status") Integer status,
                                          @Query("startTime") Long startTime, @Query("endTime") Long endTime,
                                          @Query("offset") int offset, @Query("limit") int limit,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/withdraw/history")
    Call<List<Withdraw>> getWithdrawHistory(@Query("coin") String coin, @Query("withdrawOrderId") String withdrawOrderId, @Query("status") Integer status,
                                            @Query("startTime") Long startTime, @Query("endTime") Long endTime,
                                            @Query("offset") int offset, @Query("limit") int limit,
                                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/deposit/address")
    Call<DepositAddress> getDepositAddress(@Query("coin") String asset, @Query("network") String network, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    // asset endpoints
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/asset/transfer")
    Call<UniversalTransferResult> universalTransfer(@Query("type") String type, @Query("asset") String asset, @Query("amount") String amount, @Query("fromSymbol") String fromSymbol, @Query("toSymbol") String toSymbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v3/asset/getUserAsset")
    Call<List<WalletAssetBalance>> getUserAsset(@Query("asset") String asset, @Query("needBtcValuation") Boolean needBtcValuation, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/asset/get-funding-asset")
    Call<List<WalletAssetBalance>> getFundingAsset(@Query("asset") String asset, @Query("needBtcValuation") Boolean needBtcValuation, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/asset/transfer")
    Call<UniversalTransferHistoryResult> getUniversalTransferHistory(@Query("type") UniversalTransferType type,
                                            @Query("startTime") Long startTime, @Query("endTime") Long endTime,
                                            @Query("current") Integer current, @Query("size") Integer size,
                                            @Query("fromSymbol") String fromSymbol, @Query("toSymbol") String toSymbol,
                                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    // User stream endpoints
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/api/v1/userDataStream")
    Call<ListenKey> startUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/api/v1/userDataStream")
    Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/api/v1/userDataStream")
    Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);

    // Margin Account endpoints
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/transfer")
    Call<MarginTransaction> transfer(@Query("asset") String asset, @Query("amount") String amount, @Query("type") String type, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/loan")
    Call<MarginTransaction> borrow(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/loan")
    Call<LoanQueryResult> queryLoan(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/maxBorrowable")
    Call<MaxBorrowableQueryResult> queryMaxBorrowable(@Query("asset") String asset, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("startTime") Long starttime, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/repay")
    Call<MarginTransaction> repay(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/account")
    Call<MarginAccount> getMarginAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/openOrders")
    Call<List<Order>> getOpenMarginOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/order")
    Call<NewOrderResponse> newMarginOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                          @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                                          @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                          @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/order")
    Call<CancelOrderResponse> cancelMarginOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                                @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                                @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/order")
    Call<Order> getMarginOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                     @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                                     @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/myTrades")
    Call<List<Trade>> getMyMarginTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                        @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream")
    Call<ListenKey> startMarginUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream")
    Call<Void> keepAliveMarginUserDataStream(@Query("listenKey") String listenKey);

    // Binance Liquidity Swap Pool endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/bswap/pools")
    Call<List<Pool>> listAllSwapPools();

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidity")
    Call<List<Liquidity>> getPoolLiquidityInfo(@Query("poolId") String poolId,
                                               @Query("recvWindow") Long recvWindow,
                                               @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityAdd")
    Call<LiquidityOperationRecord> addLiquidity(@Query("poolId") String poolId,
                                                @Query("asset") String asset,
                                                @Query("quantity") String quantity,
                                                @Query("recvWindow") Long recvWindow,
                                                @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityRemove")
    Call<LiquidityOperationRecord> removeLiquidity(@Query("poolId") String poolId,
                                                   @Query("type") SwapRemoveType type,
                                                   @Query("asset") List<String> asset,
                                                   @Query("shareAmount") String shareAmount,
                                                   @Query("recvWindow") Long recvWindow,
                                                   @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getPoolLiquidityOperationRecords(
            @Query("poolId") String poolId,
            @Query("limit") Integer limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getLiquidityOperationRecord(
            @Query("operationId") String operationId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/quote")
    Call<SwapQuote> requestQuote(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/swap")
    Call<SwapRecord> swap(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/swap")
    Call<List<SwapHistory>> getSwapHistory(
            @Query("swapId") String swapId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);


}
