package com.rbkmoney.adapter.cashreg.spring.boot.starter.exception;

public class UnknownTargetTypeException extends RuntimeException {
    public UnknownTargetTypeException() {
        super("Unknown target type!");
    }
}
