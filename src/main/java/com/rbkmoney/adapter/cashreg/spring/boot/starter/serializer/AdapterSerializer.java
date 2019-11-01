package com.rbkmoney.adapter.cashreg.spring.boot.starter.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterContext;
import com.rbkmoney.adapter.common.serializer.StateSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
 *      Object objectResult = serializer.read(byteResult)
 * }
 * </pre>
 */
@Component
public class AdapterSerializer extends StateSerializer<AdapterContext> {

    // TODO: need Deserializer for read?
    public AdapterSerializer(ObjectMapper mapper) {
        super(mapper);
    }

    public AdapterContext read(byte[] data) {
        if (data == null) {
            return new AdapterContext();
        }
        try {
            return getMapper().readValue(data, AdapterContext.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}