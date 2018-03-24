package com.example.stock_api.mapper;

import com.example.stock_api.domain.display.SimpleBollingerBands;
import com.example.stock_api.domain.response.BollingerBandsResponse;
import org.springframework.stereotype.Component;

/**
 * Created by marcin.bracisiewicz
 */
@Component
public class SimpleBollingerBandsMapper {

    public SimpleBollingerBands fromResponse(final BollingerBandsResponse bollingerBandsResponse) {
        final SimpleBollingerBands simpleBollingerBands = new SimpleBollingerBands();
        final String refreshDate = bollingerBandsResponse.getMetaData().getLastRefreshed();
        simpleBollingerBands.setSymbol(bollingerBandsResponse.getMetaData().getSymbol());
        simpleBollingerBands.setDate(refreshDate);
        simpleBollingerBands.setBollingerBands(bollingerBandsResponse.getTechnicalAnalysisData().get(refreshDate));
        return simpleBollingerBands;
    }
}
