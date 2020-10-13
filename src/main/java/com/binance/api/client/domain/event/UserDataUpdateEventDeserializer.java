package com.binance.api.client.domain.event;

import java.io.IOException;

import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType;
import com.binance.api.client.exception.BinanceApiException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Custom deserializer for a User Data stream event, since the API can return four different responses in this stream.
 *
 * @see UserDataUpdateEvent
 */
public class UserDataUpdateEventDeserializer extends JsonDeserializer<UserDataUpdateEvent> {

  private ObjectMapper mapper;

  @Override
  public UserDataUpdateEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();

    final String eventTypeId = node.get("e").asText();
    final long eventTime = node.get("E").asLong();
    UserDataUpdateEventType userDataUpdateEventType = UserDataUpdateEventType.fromEventTypeId(eventTypeId);

    UserDataUpdateEvent userDataUpdateEvent = new UserDataUpdateEvent();
    userDataUpdateEvent.setEventType(userDataUpdateEventType);
    userDataUpdateEvent.setEventTime(eventTime);
    switch (userDataUpdateEventType) {
      case ACCOUNT_UPDATE:
      case ACCOUNT_POSITION_UPDATE:
        userDataUpdateEvent.setAccountUpdateEvent(getUserDataUpdateEventDetail(json, AccountUpdateEvent.class, mapper));
        break;
      case BALANCE_UPDATE:
        userDataUpdateEvent.setBalanceUpdateEvent(getUserDataUpdateEventDetail(json, BalanceUpdateEvent.class, mapper));
        break;
      case ORDER_TRADE_UPDATE:
        userDataUpdateEvent.setOrderTradeUpdateEvent(getUserDataUpdateEventDetail(json, OrderTradeUpdateEvent.class, mapper));
        break;
      case OCO_TRADE_UPDATE:
        userDataUpdateEvent.setOcoTradeUpdateEvent(getUserDataUpdateEventDetail(json, OcoTradeUpdateEvent.class, mapper));
        break;
    }

    return userDataUpdateEvent;
  }

  public <T> T getUserDataUpdateEventDetail(String json, Class<T> clazz, ObjectMapper mapper) {
    try {
      return mapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new BinanceApiException(e);
    }
  }
}