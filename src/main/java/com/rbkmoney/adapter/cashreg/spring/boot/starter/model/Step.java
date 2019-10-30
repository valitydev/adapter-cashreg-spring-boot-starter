package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Step {
    CHECK_DUPLICATION,
    CREATE,
    CHECK_STATUS
}
