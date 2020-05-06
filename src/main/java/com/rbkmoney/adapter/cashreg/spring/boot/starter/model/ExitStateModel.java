package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import com.rbkmoney.damsel.cashreg.receipt.ReceiptInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExitStateModel {
    private String errorCode;
    private String errorMessage;
    private AdapterState adapterContext;
    private EntryStateModel entryStateModel;
    private String receiptId;
    private ReceiptInfo info;
}
