package com.bahcesehir.autobahn.entities.converters;


import com.bahcesehir.autobahn.entities.customs.EnrichmentRules;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class DataJsonConverter implements AttributeConverter<EnrichmentRules, String> {

    private ObjectMapper objectMapper;

    public DataJsonConverter(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(EnrichmentRules data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not convert to Json", e);
        }
    }

    @Override
    public EnrichmentRules convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, EnrichmentRules.class);
        } catch (IOException e) {
            throw new RuntimeException("Could not convert from Json", e);
        }
    }
}