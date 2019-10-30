package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntryStateModel {
    private OperationModel operationModel;
    private StateModel stateModel;
}
