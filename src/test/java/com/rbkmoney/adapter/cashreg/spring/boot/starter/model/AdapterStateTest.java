package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.common.mapper.SimpleObjectMapper;
import com.rbkmoney.adapter.common.model.PollingInfo;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;

import static org.junit.Assert.*;

public class AdapterStateTest {

    @Test
    public void testUnwrappedPollingInfo() throws IOException {
        ObjectMapper om = new SimpleObjectMapper().createSimpleObjectMapperFactory();
        AdapterState as = new AdapterState();
        as.setNextStep(Step.CHECK_STATUS);
        PollingInfo pollingInfo = new PollingInfo();
        pollingInfo.setMaxDateTimePolling(Instant.now());
        as.setPollingInfo(pollingInfo);
        String str = om.writeValueAsString(as);
        assertTrue(str.startsWith("{\"nextStep\":\"CHECK_STATUS\",\"max_date_time_polling\":"));
        AdapterState acRestored = om.readValue(str, AdapterState.class);

        assertEquals(as.getNextStep(), acRestored.getNextStep());
        assertNotNull(acRestored.getPollingInfo());
        assertEquals(as.getPollingInfo().getMaxDateTimePolling(), acRestored.getPollingInfo().getMaxDateTimePolling());
    }

    @Test
    public void testUnwrappedPollingInfoIsNull() throws IOException {
        ObjectMapper om = new SimpleObjectMapper().createSimpleObjectMapperFactory();
        AdapterState as = new AdapterState();
        as.setNextStep(Step.CHECK_STATUS);
        as.setPollingInfo(null);
        String str = om.writeValueAsString(as);
        assertTrue(str.startsWith("{\"nextStep\":\"CHECK_STATUS\""));
        AdapterState acRestored = om.readValue(str, AdapterState.class);
        assertEquals(as.getNextStep(), acRestored.getNextStep());
        assertNotNull(acRestored.getPollingInfo());
    }

}