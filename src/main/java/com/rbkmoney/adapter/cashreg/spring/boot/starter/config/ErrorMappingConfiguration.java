package com.rbkmoney.adapter.cashreg.spring.boot.starter.config;

import com.rbkmoney.adapter.common.mapper.SimpleErrorMapping;
import com.rbkmoney.error.mapping.ErrorMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Usage example:
 * <p>
 * application.yml
 * <pre>
 * {@code
 * error-mapping:
 *   file: classpath:fixture/errors.json
 *   patternReason: "'%s' - '%s'" # 'code' - 'description'
 * }
 * </pre>
 * <p>
 * Depends
 * <pre>
 * {@code
 *      @Autowired
 *      private final ErrorMapping errorMapping;
 * }
 * </pre>
 * <p>
 * Code:
 * <pre>
 * {@code
 *      Failure failure = errorMapping.mapFailure(code, reason);
 * }
 * </pre>
 *
 * @see ErrorMappingConfiguration
 */
@Configuration
public class ErrorMappingConfiguration {

    @Value("${error-mapping.file}")
    private Resource errorMappingFilePath;

    @Value("${error-mapping.patternReason:\"'%s' - '%s'\"}")
    private String errorMappingPattern;

    @Bean
    public ErrorMapping errorMapping() throws IOException {
        return new SimpleErrorMapping(errorMappingFilePath, errorMappingPattern).createErrorMapping();
    }
}
