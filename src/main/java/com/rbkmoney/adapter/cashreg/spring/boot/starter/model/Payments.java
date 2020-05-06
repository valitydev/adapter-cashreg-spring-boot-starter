package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class Payments {
    private Integer type;
    private BigDecimal sum;
}
