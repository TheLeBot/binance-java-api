package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiError;
import com.binance.api.client.config.BinanceApiConfig;
import com.binance.api.client.exception.BinanceApiException;
import okhttp3.ResponseBody;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.extras.retrofit.AsyncHttpClientCallFactory;
import org.asynchttpclient.extras.retrofit.BinanceCallCustomizer;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Generates a Binance API implementation based on @see {@link BinanceApiService}.
 */
public class BinanceApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, BinanceApiError> errorBodyConverter =
            (Converter<ResponseBody, BinanceApiError>)converterFactory.responseBodyConverter(
                    BinanceApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass, AsyncHttpClient httpClient) {
        return createService(serviceClass, httpClient, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, AsyncHttpClient httpClient, String apiKey, String secret) {
        AsyncHttpClientCallFactory.AsyncHttpClientCallFactoryBuilder callFactoryBuilder =
                AsyncHttpClientCallFactory.builder().httpClient(httpClient);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BinanceApiConstants.API_BASE_URL)
                .addConverterFactory(converterFactory)
                .validateEagerly(true);
        BinanceCallCustomizer.customize(apiKey, secret, callFactoryBuilder);
        Retrofit retrofit = retrofitBuilder.callFactory(callFactoryBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BinanceApiError apiError = getBinanceApiError(response);
                throw new BinanceApiException(apiError);
            }
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static BinanceApiError getBinanceApiError(Response<?> response) throws IOException, BinanceApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}