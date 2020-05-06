package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Setter
@Component
@AllArgsConstructor
public class AdapterDeserializer implements Deserializer<AdapterState> {

    private final ObjectMapper mapper;

    public AdapterState read(byte[] data) {
        if (data == null) {
            return new AdapterState();
        }
        try {
            return getMapper().readValue(data, AdapterState.class);
        } catch (IOException e) {
            throw new DeserializationException(e);
        }
    }

    @Override
    public AdapterState read(String data) {
        throw new DeserializationException("Not supported");
    }

}
