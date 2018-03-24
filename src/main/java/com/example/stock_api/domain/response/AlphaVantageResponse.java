package com.example.stock_api.domain.response;

import com.example.stock_api.domain.MetaData;
import com.example.stock_api.domain.RSI;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by marcin.bracisiewicz
 */
public class AlphaVantageResponse {

    //serializable ?

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Technical Analysis: RSI")
    private Map<String, RSI> technicalAnalysisData;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Map<String, RSI> getTechnicalAnalysisData() {
        return this.technicalAnalysisData;
    }

    public void setTechnicalAnalysisData(Map<String, RSI> technicalAnalysisData) {
        this.technicalAnalysisData = technicalAnalysisData;
    }
}
