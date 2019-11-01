package com.rbkmoney.adapter.cashreg.spring.boot.starter.state.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Usage example:
 *
 * <pre>
 * {@code
 *      @Autowired
 *      private final AdapterDeserializer deserializer;
 * }
 * </pre>
 * <p>
 * Code:
 * <pre>
 * {@code
 *      Object objectResult = deserializer.read(byteResult)
 * }
 * </pre>
 */
@Component
public class AdapterDeserializer extends StateDeserializer<AdapterContext> {

    public AdapterDeserializer(ObjectMapper mapper) {
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
