package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryStateModel {

    private String cashRegId;

    private Auth auth;
    private Company company;
    private Client client;

    private List<Items> items;
    private List<Payments> payments;
    private List<Vat> vats;

    private BigDecimal total;

    @ToString.Exclude
    private Map<String, String> options;

    private String callbackUrl;

    private StateModel state;

    private TargetType targetType;

}
