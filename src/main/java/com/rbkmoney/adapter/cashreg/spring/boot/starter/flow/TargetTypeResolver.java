package com.rbkmoney.adapter.cashreg.spring.boot.starter.flow;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import com.rbkmoney.geck.common.util.TBaseUtil;

public class TargetTypeResolver {

    public static TargetType resolve(com.rbkmoney.damsel.cashreg.type.Type type) {
        return TBaseUtil.unionFieldToEnum(type, TargetType.class);
    }

}
