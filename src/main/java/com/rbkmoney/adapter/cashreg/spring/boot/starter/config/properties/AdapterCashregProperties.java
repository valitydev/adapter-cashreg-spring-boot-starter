package com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * application.yml
 * <pre>
 * {@code
 *  adapter-cashreg:
 *      url: http://localhost.ru/path/v1/call
 * }
 * </pre>
 * <p>
 * Usage example:
 * <pre>
 * {@code
 *      @Autowired
 *      private final AdapterCashregProperties adapterCashregProperties;
 * }
 * </pre>
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties("adapter-cashreg")
public class AdapterCashregProperties {

    @NotEmpty
    private String url;

}
