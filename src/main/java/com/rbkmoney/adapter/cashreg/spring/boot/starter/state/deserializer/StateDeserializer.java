package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class StateDeserializer<T> implements Deserializer<T> {

    protected final ObjectMapper mapper;

    @Override
    public T read(byte[] data) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public T read(String data) {
        throw new RuntimeException("Not supported");
    }

}
