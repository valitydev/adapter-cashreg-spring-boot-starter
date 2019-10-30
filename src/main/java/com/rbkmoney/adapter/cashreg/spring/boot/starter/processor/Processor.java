package com.rbkmoney.adapter.cashreg.spring.boot.starter.processor;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;

public interface Processor<T extends ExitStateModel, E extends EntryStateModel, R> {
    T process(R response, E context);
}
