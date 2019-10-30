package com.rbkmoney.adapter.cashreg.spring.boot.starter.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Error {

    DEFAULT_ERROR_CODE("error", "error"),
    UNKNOWN("unknown_code", "Unknown error!"),
    EMPTY_BODY("Empty body", "Empty body"),

    SLEEP_TIMEOUT("Sleep timeout", "Max time pool limit reached");

    private final String code;
    private final String message;

}
