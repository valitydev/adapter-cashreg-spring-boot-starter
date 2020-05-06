package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Client {
    private String email;
    private String phone;
    private String sno;
}
