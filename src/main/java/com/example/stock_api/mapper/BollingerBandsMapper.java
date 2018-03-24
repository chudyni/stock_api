package com.example.stock_api.mapper;

import com.example.stock_api.domain.response.BollingerBandsResponse;
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
public class BollingerBandsMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(BollingerBandsMapper.class);

    @Autowired
    private ObjectMapper objectMapper;

    public BollingerBandsResponse map(final String response) {
        BollingerBandsResponse bollingerBandsResponse = new BollingerBandsResponse();
        try {
            bollingerBandsResponse = this.objectMapper.readValue(response, BollingerBandsResponse.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return bollingerBandsResponse;
    }
}
