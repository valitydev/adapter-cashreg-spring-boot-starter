package com.rbkmoney.adapter.cashreg.spring.boot.starter.handler;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import org.apache.thrift.TException;

public interface CommonHandler<T, R, E extends EntryStateModel> {
    boolean isHandler(final E entryStateModel);

    T handle(E context) throws TException;
}
