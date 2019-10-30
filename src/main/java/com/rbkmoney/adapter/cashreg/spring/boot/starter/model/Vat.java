package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Builder
public class Vat {
    private String type;
    private BigDecimal sum;
}
