package com.binance.api.examples;

import com.binance.api.HttpUtils;
import com.binance.api.client.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.TransferType;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.asynchttpclient.AsyncHttpClient;

/**
 * Examples on how to get margin account information asynchronously.
 */
public class MarginAccountEndpointsExampleAsync {

  public static void main(String[] args) {
    final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
    final AsyncHttpClient asyncHttpClient = HttpUtils.newAsyncHttpClient(eventLoopGroup, 65536);
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(asyncHttpClient);
    BinanceApiAsyncMarginRestClient client = factory.newAsyncMarginRestClient();

    // Get account balances
    client.getAccount(marginAccount -> {
      System.out.println(marginAccount.getUserAssets());
      System.out.println(marginAccount.getAssetBalance("ETH"));
      System.out.println(marginAccount.getMarginLevel());
    });

    // Get list of trades
    client.getMyTrades("NEOETH", myTrades -> {
      System.out.println(myTrades);
    });

    // Transfer, borrow, repay
    client.transfer("USDT", "1", TransferType.SPOT_TO_MARGIN, transaction -> System.out.println(transaction.getTranId()));
    client.borrow("USDT", "1", transaction -> System.out.println(transaction.getTranId()));
    client.repay("USDT", "1", transaction -> System.out.println(transaction.getTranId()));
    client.transfer("USDT", "1", TransferType.MARGIN_TO_SPOT, transaction -> System.out.println(transaction.getTranId()));
  }
}
