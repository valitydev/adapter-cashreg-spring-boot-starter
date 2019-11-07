package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer;

public interface Serializer<TState> {

    byte[] writeByte(Object obj);

    String writeString(Object obj);

}
