package com.rbkmoney.adapter.cashreg.spring.boot.starter.flow;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import org.apache.thrift.TUnion;

import java.util.Objects;

public class TargetTypeResolver {

    public static TargetType resolve(com.rbkmoney.damsel.cashreg.type.Type type) {
        return TargetTypeResolver.unionFieldToEnum(type, TargetType.class);
    }

    private static <T extends Enum<T>> T unionFieldToEnum(TUnion union, Class<T> enumType) {
        Objects.requireNonNull(union, "Union must be set");
        return Enum.valueOf(enumType, union.getSetField().getFieldName().toUpperCase());
    }

}
