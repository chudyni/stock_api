package com.example.stock_api.connection.impl;

import com.example.stock_api.connection.ApiConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by marcin.bracisiewicz
 */
@Component
public class AlphaVantageConnection implements ApiConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlphaVantageConnection.class);

//    private static final String BASE_URL = "https://www.alphavantage.co/query?";
//    private final String apiKey = "ZB67CH15GT8QP3L1";
    private final int timeOut = 25_000;

    //NO THREAD SAFE
    //no possibility to get into race condition at the moment (1 user only)
    private int retryCounter = 0;

    // try with resource
    // should close
    public String getRequest(String url) {
        try {

            // LOGGER needed
            LOGGER.info("GETTING: " + url);

            URL e = new URL(url);
            URLConnection connection = e.openConnection();
            connection.setConnectTimeout(this.timeOut);
            connection.setReadTimeout(this.timeOut);
            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            StringBuilder responseBuilder = new StringBuilder();

            String line;
            while((line = bufferedReader.readLine()) != null) {
                responseBuilder.append(line);
            }

            bufferedReader.close();

            this.retryCounter = 0;
            return responseBuilder.toString();
        } catch (IOException ex) {

            // LOG ERROR when face for example - 10 times of retry
            LOGGER.info("RETRYING: " + ++this.retryCounter);

            // add max counter ?
            //endless loop in worst case
            return this.getRequest(url);
        }
    }

}
