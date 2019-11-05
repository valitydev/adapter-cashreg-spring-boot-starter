package com.rbkmoney.adapter.cashreg.spring.boot.starter.converter;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer.AdapterDeserializer;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Usage example:
 * <pre>
 * {@code
 *      @Autowired
 *      CashRegAdapterContextConverter cashRegAdapterContextConverter;
 * }
 * </pre>
 *
 * <pre>
 * {@code
 *      AdapterContext adapterContext = cashRegAdapterContextConverter.convert(cashRegContext)
 * }
 * </pre>
 */
@Component
@RequiredArgsConstructor
public class CashRegAdapterContextConverter implements Converter<CashRegContext, AdapterState> {

    private static final byte[] DEFAULT_STATE = new byte[0];

    private final AdapterDeserializer deserializer;

    @Override
    public AdapterState convert(CashRegContext context) {
        AdapterState adapterContext = new AdapterState();
        byte[] state = getState(context);
        if (state != null && state.length > 0) {
            return deserializer.read(state);
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
