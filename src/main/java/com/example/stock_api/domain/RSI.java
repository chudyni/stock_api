package com.example.stock_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by marcin.bracisiewicz
 */
public class RSI {

    @JsonProperty("RSI")
    private String rsi;

    public String getRsi() {
        return rsi;
    }

    public void setRsi(String rsi) {
        this.rsi = rsi;
    }
}
