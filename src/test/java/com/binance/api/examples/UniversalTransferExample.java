package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.UniversalTransferType;
import com.binance.api.client.domain.account.UniversalTransferResult;

public class UniversalTransferExample {

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiRestClient client = factory.newRestClient();

        UniversalTransferType type = UniversalTransferType.MAIN_CMFUTURE;

        UniversalTransferResult result = client.universalTransfer( type, "BNB", "1");

        System.out.println(result);

        type = UniversalTransferType.CMFUTURE_MAIN;

        result = client.universalTransfer(type, "BNB", "1");

        System.out.println(result);
    }
}