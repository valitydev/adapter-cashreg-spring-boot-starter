package com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


/**
 * application.yml
 * <pre>
 * {@code
 * time:
 *   config:
 *      maxTimePolling: 600
 *      pollingDelay: 600
 * }
 * </pre>
 * <p>
 * Usage example:
 * <pre>
 * {@code
 *      @Autowired
 *      private final TimerProperties timeProperties;
 * }
 * </pre>
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties("time.config")
public class TimerProperties {

    @NotNull
    private int maxTimePolling;

    @NotNull
    private int pollingDelay;

}
