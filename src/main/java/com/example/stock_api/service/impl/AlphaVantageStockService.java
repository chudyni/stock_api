package com.example.stock_api.service.impl;

import com.example.stock_api.connection.ApiConnection;
import com.example.stock_api.domain.display.SimpleBollingerBands;
import com.example.stock_api.domain.response.BollingerBandsResponse;
import com.example.stock_api.mapper.BollingerBandsMapper;
import com.example.stock_api.mapper.SimpleBollingerBandsMapper;
import com.example.stock_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcin.bracisiewicz
 */
@Service
public class AlphaVantageStockService implements StockService {

//    private static final String BOLLINGER_BANDS = "https://www.alphavantage.co/query?function=BBANDS&interval=daily&time_period=20&series_type=close&nbdevup=3&nbdevdn=3&apikey=ZB67CH15GT8QP3L1&symbol=%s";
    private static final String BOLLINGER_BANDS = "https://www.alphavantage.co/query?function=BBANDS&interval=daily&time_period=20&series_type=close&apikey=ZB67CH15GT8QP3L1&symbol=%s";

    @Autowired
    private ApiConnection apiConnection;

    @Autowired
    private BollingerBandsMapper mapper;

    @Autowired
    private SimpleBollingerBandsMapper simpleBollingerBandsMapper;

    @Override
    public SimpleBollingerBands getBollingerBands(final String symbol) {
        final String url = String.format(BOLLINGER_BANDS, symbol);
        final BollingerBandsResponse response = this.mapper.map(this.apiConnection.getRequest(url));
        return simpleBollingerBandsMapper.fromResponse(response);
    }
}
