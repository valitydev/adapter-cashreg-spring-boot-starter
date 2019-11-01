package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterContext;
import com.rbkmoney.adapter.common.serializer.StateSerializer;
import org.springframework.stereotype.Component;

/**
 * Usage example:
 *
 * <pre>
 * {@code
 *      @Autowired
 *      private final AdapterSerializer serializer;
 * }
 * </pre>
 * <p>
 * Code:
 * <pre>
 * {@code
 *      byte[] byteResult = serializer.writeByte(Object)
 * }
 * </pre>
 */
@Component
public class AdapterSerializer extends StateSerializer<AdapterContext> {

    public AdapterSerializer(ObjectMapper mapper) {
        super(mapper);
    }

}