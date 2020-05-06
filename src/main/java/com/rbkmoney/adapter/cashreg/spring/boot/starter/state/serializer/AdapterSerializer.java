package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import org.springframework.stereotype.Component;

@Component
public class AdapterSerializer extends StateSerializer<AdapterState> {

    public AdapterSerializer(ObjectMapper mapper) {
        super(mapper);
    }

}