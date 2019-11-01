package com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Map;

import static java.lang.Integer.parseInt;


/**
 * Usage example:
 *
 * <pre>
 * {@code
 *     Integer pollingDelay = OptionsExtractors.extractPollingDelay(options, 600);
 * }
 * </pre>
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionsExtractors {

    public static Integer extractPollingDelay(Map<String, String> options, int pollingDelay) {
        return parseInt(options.getOrDefault(OptionalField.POLLING_DELAY.getField(), String.valueOf(pollingDelay)));
    }

    public static Integer extractMaxTimePolling(Map<String, String> options, int maxTimePolling) {
        return Integer.parseInt(options.getOrDefault(OptionalField.MAX_TIME_POLLING.getField(), String.valueOf(maxTimePolling)));
    }

}
