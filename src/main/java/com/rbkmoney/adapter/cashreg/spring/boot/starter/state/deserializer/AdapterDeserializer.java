package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class AdapterDeserializer extends StateDeserializer<AdapterState> {

    public AdapterDeserializer(ObjectMapper mapper) {
        super(mapper);
    }

    public AdapterState read(byte[] data) {
        if (data == null) {
            return new AdapterState();
        }
        try {
            return getMapper().readValue(data, AdapterState.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
