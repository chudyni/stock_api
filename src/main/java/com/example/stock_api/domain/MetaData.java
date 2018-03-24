package com.example.stock_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by marcin.bracisiewicz
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {

    @JsonProperty("1: Symbol")
    private String symbol;

    @JsonProperty("2: Indicator")
    private String indicator;

    @JsonProperty("3: Last Refreshed")
    private String lastRefreshed;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }
}
