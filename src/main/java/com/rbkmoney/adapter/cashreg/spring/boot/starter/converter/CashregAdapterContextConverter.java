package com.rbkmoney.adapter.cashreg.spring.boot.starter.converter;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer.AdapterDeserializer;
import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Usage example:
 * <pre>
 * {@code
 *      @Autowired
 *      CashregAdapterContextConverter cashregAdapterContextConverter;
 * }
 * </pre>
 *
 * <pre>
 * {@code
 *      AdapterContext adapterContext = cashregAdapterContextConverter.convert(cashregContext)
 * }
 * </pre>
 */
@Component
@RequiredArgsConstructor
public class CashregAdapterContextConverter implements Converter<CashregContext, AdapterState> {

    private static final byte[] DEFAULT_STATE = new byte[0];

    private final AdapterDeserializer deserializer;

    @Override
    public AdapterState convert(CashregContext context) {
        AdapterState adapterContext = new AdapterState();
        byte[] state = getState(context);
        if (state != null && state.length > 0) {
            return deserializer.read(state);
        }
        return adapterContext;
    }

    private byte[] getState(CashregContext context) {
        if (context.getSession().isSetState()) {
            return context.getSession().getState();
        }
        return DEFAULT_STATE;
    }

}
