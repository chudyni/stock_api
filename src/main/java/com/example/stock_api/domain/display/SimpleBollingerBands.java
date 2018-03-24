package com.example.stock_api.domain.display;

import com.example.stock_api.domain.BollingerBands;

/**
 * Created by marcin.bracisiewicz
 */
public class SimpleBollingerBands {

    private String symbol;
    private String date;
    private BollingerBands bollingerBands;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BollingerBands getBollingerBands() {
        return bollingerBands;
    }

    public void setBollingerBands(BollingerBands bollingerBands) {
        this.bollingerBands = bollingerBands;
    }

    @Override
    public String toString() {
        return String.format("Symbol: %s\nUS Estern date(-6h): %s\nUpper: %s\nMiddle: %s\n Lower: %s", this.symbol, this.date,
                this.bollingerBands.getUpper(), this.bollingerBands.getMiddle(), this.bollingerBands.getLower());
    }
}
