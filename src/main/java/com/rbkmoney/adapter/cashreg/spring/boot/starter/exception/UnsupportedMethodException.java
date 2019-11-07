package com.rbkmoney.adapter.cashreg.spring.boot.starter.exception;

import org.apache.thrift.TException;

public class UnsupportedMethodException extends TException {
    public UnsupportedMethodException() {
        super("Unsupported method");
    }
}
