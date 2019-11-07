package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import com.rbkmoney.adapter.common.serializer.StateSerializer;
import org.springframework.stereotype.Component;


@Component
public class AdapterSerializer extends StateSerializer<AdapterState> {

    public AdapterSerializer(ObjectMapper mapper) {
        super(mapper);
    }

}