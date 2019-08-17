package com.littlejohnny.product.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class MappersFactory {

    private static ObjectMapper OBJECT_MAPPER;

    private static ObjectMapper configureMapper(ObjectMapper objectMapper) {
        return objectMapper;
    }

    public static ObjectMapper getJSONMapper() {
        return  Objects.nonNull(OBJECT_MAPPER) ? OBJECT_MAPPER : configureMapper(new ObjectMapper());
    }
}
