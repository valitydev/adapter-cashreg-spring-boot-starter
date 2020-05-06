package com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class OptionsExtractors {

    public static Integer extractPollingDelay(Map<String, String> options, int pollingDelay) {
        return parseInt(options.getOrDefault(OptionalField.POLLING_DELAY.getField(), String.valueOf(pollingDelay)));
    }

    public static Integer extractMaxTimePolling(Map<String, String> options, int maxTimePolling) {
        return Integer.parseInt(options.getOrDefault(OptionalField.MAX_TIME_POLLING.getField(), String.valueOf(maxTimePolling)));
    }

}
