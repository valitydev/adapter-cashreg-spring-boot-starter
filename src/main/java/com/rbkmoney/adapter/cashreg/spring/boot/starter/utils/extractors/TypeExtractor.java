package com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors;

import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import com.rbkmoney.damsel.cashreg.type.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeExtractor {

    public static String extractCashRegType(CashRegContext context) {
        return extractCashRegType(context.getSession().getType());
    }

    public static String extractCashRegType(Type type) {
        return type.getSetField().getFieldName().toUpperCase();
    }

}
