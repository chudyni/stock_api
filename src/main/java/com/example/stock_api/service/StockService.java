package com.example.stock_api.service;

import com.example.stock_api.domain.display.SimpleBollingerBands;

/**
 * Created by marcin.bracisiewicz
 */
public interface StockService {

    SimpleBollingerBands getBollingerBands(final String symbol);
}
