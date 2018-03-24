package com.example.stock_api.service.impl;

import com.example.stock_api.service.QuandlService;
import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;
import org.springframework.stereotype.Service;

/**
 * Created by marcin.bracisiewicz
 */
@Service
public class QuandlServiceImpl implements QuandlService {

    //gb6y9W17tKrSEdqxagN2
    //https://www.quandl.com/api/v3/datasets/WIKI/MOS/data.json?api_key=gb6y9W17tKrSEdqxagN2
    //https://www.quandl.com/api/v3/datasets/LBMA/GOLD.json
    //https://www.quandl.com/api/v3/datasets/CHRIS/ICE_DX1.json
    //http://www.quandl.com/api/v3/datasets/BOE/XUDLBK49,json

    //http://quandl4j.org/
    //https://blog.quandl.com/api-for-commodity-data

    @Override
    public String getGoldPrice() {
        return this.getResponse("LBMA/GOLD");
    }

    @Override
    public String getUSDIndex() {
        return this.getResponse("CHRIS/ICE_DX1");
    }

    @Override
    public String getUSDPLN() {
        return this.getResponse("BOE/XUDLBK49");
    }

    private String getResponse(final String marketCode) {
        final ClassicQuandlSession session = ClassicQuandlSession.create();
        final DataSetRequest.Builder builder = DataSetRequest.Builder
                .of(marketCode);
        final TabularResult tabularResult = session.getDataSet(builder.build());
        return tabularResult.toPrettyPrintedString();
    }

}
