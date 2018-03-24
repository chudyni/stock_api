package com.example.stock_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by marcin.bracisiewicz
 */
public class BollingerBands {

    @JsonProperty("Real Upper Band")
    private String upper;

    @JsonProperty("Real Middle Band")
    private String middle;

    @JsonProperty("Real Lower Band")
    private String lower;

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }
}
