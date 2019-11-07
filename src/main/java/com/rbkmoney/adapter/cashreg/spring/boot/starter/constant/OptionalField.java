package com.rbkmoney.adapter.cashreg.spring.boot.starter.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OptionalField {

    URL("url"),
    GROUP("group"),
    LOGIN("login"),
    PASS("pass"),

    CLIENT_ID("client_id"),
    TAX_ID("tax_id"),
    TAX_MODE("tax_mode"),

    COMPANY_INN("company_inn"),
    COMPANY_NAME("company_name"),
    COMPANY_ADDRESS("company_address"),
    COMPANY_EMAIL("company_email"),

    POLLING_DELAY("polling_delay"),
    MAX_TIME_POLLING("max_time_polling"),

    TIMER_TIMEOUT("timer_timeout"),
    TIMER_ADD_TIME("timer_add_time"),

    PRIVATE_KEY("private_key"),
    KEY("key"),

    PAYMENT_METHOD("payment_method"),
    PAYMENT_OBJECT("payment_object");

    private final String field;
}
