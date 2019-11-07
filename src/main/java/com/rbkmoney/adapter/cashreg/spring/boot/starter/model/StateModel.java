package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateModel {
    private TargetType targetType;
    private AdapterState adapterContext;
}
