package com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Configuration
@ConfigurationProperties("adapter-cashreg")
@Validated
public class AdapterCashRegProperties {

    @NotEmpty
    private String url;

}
