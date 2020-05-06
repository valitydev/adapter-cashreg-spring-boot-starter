package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Company {
    private String email;
    private String sno;
    private String inn;
    private String paymentAddress;
}
