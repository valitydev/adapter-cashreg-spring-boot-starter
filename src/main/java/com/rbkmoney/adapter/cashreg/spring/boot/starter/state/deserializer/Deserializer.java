package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer;

public interface Deserializer<TDState> {

    TDState read(byte[] data);

    TDState read(String data);

}
