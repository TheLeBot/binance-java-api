package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.exception.BinanceApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BinanceApiWebSocketListener<T> implements WebSocketListener {

    private static final Logger log = LoggerFactory.getLogger(BinanceApiWebSocketListener.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final ObjectReader objectReader;
    private final BinanceApiCallback<T> callback;

    private WebSocket webSocket = null;
    private String wsName = null;

    public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = MAPPER.readerFor(eventClass);
    }

    public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, TypeReference reference) {
        this.callback = callback;
        this.objectReader = MAPPER.readerFor(reference);
    }

    @Override
    public void onPingFrame(byte[] payload) {
        log.info(String.format("WebSocket %s received ping, sending pong back..", wsName));
        this.webSocket.sendPongFrame(payload);
    }

    /**
     * Remember that callback should never block event loop!!
     */
    @Override
    public void onTextFrame(String payload, boolean finalFragment, int rsv) {
        try {
            T event = objectReader.readValue(payload);
            this.callback.onResponse(event);
        } catch (IOException ex) {
            log.error("Error at WebSocket " + wsName, ex);
            throw new BinanceApiException(ex);
        }
    }

    @Override
    public void onOpen(WebSocket websocket) {
        this.webSocket = websocket;
        this.wsName = websocket.toString();
        log.info(String.format("WebSocket %s opened", wsName));
    }

    @Override
    public void onClose(WebSocket websocket, int code, String reason) {
        log.info(String.format("WebSocket %s was closed..", wsName));
    }

    @Override
    public void onError(Throwable t) {
        log.error(String.format("Error at WebSocket %s: ", wsName), t);
    }

    public WebSocket getWebSocket() {
        return this.webSocket;
    }
}