package com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors;

import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import com.rbkmoney.damsel.cashreg.receipt.type.Type;

public class TypeExtractor {

    public static String extractCashregType(CashregContext context) {
        return extractCashregType(context.getSession().getType());
    }

    public static String extractCashregType(Type type) {
        return type.getSetField().getFieldName().toUpperCase();
    }

}
