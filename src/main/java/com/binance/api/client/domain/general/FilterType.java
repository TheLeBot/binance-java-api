package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two forms: symbol filters and exchange filters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FilterType {
  // Symbol
  PRICE_FILTER,
  PERCENT_PRICE,
  PERCENT_PRICE_BY_SIDE,
  LOT_SIZE,
  MIN_NOTIONAL,
  NOTIONAL,
  ICEBERG_PARTS,
  MARKET_LOT_SIZE,
  MAX_NUM_ORDERS,
  MAX_NUM_ALGO_ORDERS,
  MAX_NUM_ICEBERG_ORDERS,
  MAX_NUM_ORDER_LISTS,
  MAX_NUM_ORDER_AMENDS,
  MAX_POSITION,
  TRAILING_DELTA,

  // Exchange
  EXCHANGE_MAX_NUM_ORDERS,
  EXCHANGE_MAX_NUM_ALGO_ORDERS,
  EXCHANGE_MAX_NUM_ICEBERG_ORDERS,
  EXCHANGE_MAX_NUM_ORDER_LISTS
}
