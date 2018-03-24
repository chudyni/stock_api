package com.example.stock_api.domain.response;

import com.example.stock_api.domain.BollingerBands;
import com.example.stock_api.domain.MetaData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by marcin.bracisiewicz
 */
public class BollingerBandsResponse {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Technical Analysis: BBANDS")
    private Map<String, BollingerBands> technicalAnalysisData;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Map<String, BollingerBands> getTechnicalAnalysisData() {
        return this.technicalAnalysisData;
    }

    public void setTechnicalAnalysisData(Map<String, BollingerBands> technicalAnalysisData) {
        this.technicalAnalysisData = technicalAnalysisData;
    }
}
