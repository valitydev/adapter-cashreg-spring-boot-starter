package com.rbkmoney.adapter.cashreg.spring.boot.starter.config;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.converter.ip.ConverterIp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Usage example:
 * <p>
 * application.yml
 * <pre>
 * {@code
 * converterIp:
 *   nat64prefix: "2a04:4a00:5:10ff:4:1:"
 * }
 * </pre>
 *
 * @see ConverterIp
 */
@Configuration
public class ConverterIpConfiguration {

    @Bean
    ConverterIp converterIp(@Value("${converterIp.nat64prefix:" + ConverterIp.NAT_64_PREFIX + "}") String nat64prefix) {
        return new ConverterIp(nat64prefix);
    }

}
