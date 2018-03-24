package com.example.stock_api.mapper;

import com.example.stock_api.domain.response.AlphaVantageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by marcin.bracisiewicz
 */
@Component
public class AlphaVantageMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlphaVantageMapper.class);

    @Autowired
    private ObjectMapper objectMapper;

    public AlphaVantageResponse map(String response) {
        AlphaVantageResponse alphaVantageResponse = new AlphaVantageResponse();
        try {
            alphaVantageResponse = objectMapper.readValue(response, AlphaVantageResponse.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return alphaVantageResponse;
    }
}
