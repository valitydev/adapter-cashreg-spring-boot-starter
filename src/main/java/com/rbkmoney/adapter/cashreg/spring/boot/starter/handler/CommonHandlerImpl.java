package com.rbkmoney.adapter.cashreg.spring.boot.starter.handler;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public abstract class CommonHandlerImpl<T extends ExitStateModel, P, R, E extends EntryStateModel> implements CommonHandler<T, R, E> {

    private final Function<P, R> requestFunction;
    private final Converter<E, P> converter;
    private final Processor<T, E, R> processor;

    @Override
    public T handle(E entryStateModel) {
        P request = converter.convert(entryStateModel);
        R response = requestFunction.apply(request);
        return processor.process(response, entryStateModel);
    }

}