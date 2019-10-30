package com.rbkmoney.adapter.cashreg.spring.boot.starter.flow;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.exception.UnknownTargetTypeException;
import org.springframework.stereotype.Component;

@Component
public class TargetTypeResolver {

    public TargetType resolve(com.rbkmoney.damsel.cashreg.type.Type type) {
        if (type != null) {
            if (type.isSetCredit()) {
                return TargetType.CREDIT;
            } else if (type.isSetDebit()) {
                return TargetType.DEBIT;
            } else if (type.isSetRefundDebit()) {
                return TargetType.REFUND_DEBIT;
            } else if (type.isSetRefundCredit()) {
                return TargetType.REFUND_CREDIT;
            }
        }
        throw new UnknownTargetTypeException();
    }

}
