package org.asynchttpclient.extras.retrofit;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.security.HmacSHA256Signer;
import org.apache.commons.lang3.StringUtils;
import org.asynchttpclient.Request;

import java.util.stream.Collectors;

public class BinanceCallCustomizer {

    private static final String eq = "=";

    /**
     * Couldn't access call customizer class out of package scope,
     * as a workaround applying from here
     * @param apiKey
     * @param secret
     * @param builder
     */
    public static void customize(String apiKey, String secret, AsyncHttpClientCallFactory.AsyncHttpClientCallFactoryBuilder builder) {
        if (StringUtils.isNotEmpty(apiKey) && StringUtils.isNotEmpty(secret)) {
            builder.callCustomizer(c -> c.requestCustomizer( r -> {
                Request original = r.build();
                boolean isApiKeyRequired = original.getHeaders().contains(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY);
                boolean isSignatureRequired = original.getHeaders().contains(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED);

                // Endpoint requires sending a valid API-KEY
                if (isApiKeyRequired || isSignatureRequired) {
                    r.clearHeaders();
                    r.addHeader(BinanceApiConstants.API_KEY_HEADER, apiKey);
                    r.addHeader("Content-Type", "application/json");
                }
                // Endpoint requires signing the payload
                if (isSignatureRequired) {
                    String payload = original.getQueryParams().stream()
                            .map(e -> e.getName() + eq + e.getValue())
                            .collect(Collectors.joining("&"));
                    if (!StringUtils.isEmpty(payload)) {
                        String signature = HmacSHA256Signer.sign(payload, secret);
                        r.addQueryParam("signature", signature);
                    }
                }
            }));
        }
    }
}
