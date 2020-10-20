package com.binance.api.examples;

import com.binance.api.HttpUtils;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.domain.account.*;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.asynchttpclient.AsyncHttpClient;

import java.util.List;

public class SwapEndpointExample {

    public static String API_KEY = "api-key";
    public static String SECRET_KEY = "secret-key";

    public static void main(String[] args) {

        final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
        final AsyncHttpClient asyncHttpClient = HttpUtils.newAsyncHttpClient(eventLoopGroup, 65536);
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET", asyncHttpClient);
        BinanceApiSwapRestClient swapClient = factory.newSwapRestClient();

        List<Pool> pools = swapClient.listAllSwapPools();
        for(Pool pool:pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        System.out.println(swapQuote);
        SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        SwapHistory swapHistory = swapClient.getSwapHistory(swapRecord.getSwapId());
        System.out.println(swapHistory);
    }


}
