package com.binance.api.examples;

import com.binance.api.HttpUtils;
import com.binance.api.client.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.asynchttpclient.AsyncHttpClient;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class MarginOrdersExampleAsync {

  public static void main(String[] args) {
    final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
    final AsyncHttpClient asyncHttpClient = HttpUtils.newAsyncHttpClient(eventLoopGroup, 65536);
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(asyncHttpClient);
    BinanceApiAsyncMarginRestClient client = factory.newAsyncMarginRestClient();

    // Getting list of open orders
    client.getOpenOrders(new OrderRequest("LINKETH"), response -> System.out.println(response));

    // Get status of a particular order
    client.getOrderStatus(new OrderStatusRequest("LINKETH", 745262L),
        response -> System.out.println(response));

    // Canceling an order
    client.cancelOrder(new CancelOrderRequest("LINKETH", 756703L),
        response -> System.out.println(response));

    // Placing a real LIMIT order
    client.newOrder(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001"),
        response -> System.out.println(response));
  }
}
