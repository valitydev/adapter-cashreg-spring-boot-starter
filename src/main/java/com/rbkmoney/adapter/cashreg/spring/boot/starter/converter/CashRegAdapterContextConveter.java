package com.rbkmoney.adapter.cashreg.spring.boot.starter.converter;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterContext;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.serializer.AdapterSerializer;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CashRegAdapterContextConveter implements Converter<CashRegContext, AdapterContext> {

    private static final byte[] DEFAULT_STATE = new byte[0];

    private final AdapterSerializer serializer;

    @Override
    public AdapterContext convert(CashRegContext context) {
        AdapterContext adapterContext = new AdapterContext();
        byte[] state = getState(context);
        if (state != null && state.length > 0) {
            return serializer.read(state);
        }
        return adapterContext;
    }

    private byte[] getState(CashRegContext context) {
        if (context.getSession().isSetState()) {
            return context.getSession().getState();
        }
        return DEFAULT_STATE;
    }

}
