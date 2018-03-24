package com.example.stock_api.controller;

import com.example.stock_api.domain.display.SimpleBollingerBands;
import com.example.stock_api.service.QuandlService;
import com.example.stock_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcin.bracisiewicz
 */
@RestController
public class StockInfoController {

    @Autowired
    public StockService stockService;

    @Autowired
    public QuandlService quandlService;

    @GetMapping("/bands/{symbol}")
    public SimpleBollingerBands simpleBollingerBands(@PathVariable final String symbol) {
        return this.stockService.getBollingerBands(symbol);
    }

    @GetMapping("/gold")
    public String goldPrice() {
        return this.quandlService.getGoldPrice();
    }

    @GetMapping("/USD/index")
    public String dolarIndex() {
        return this.quandlService.getUSDIndex();
    }

    @GetMapping("/USD/price")
    public String dolarPLNPrice() {
        return this.quandlService.getUSDPLN();
    }
}
