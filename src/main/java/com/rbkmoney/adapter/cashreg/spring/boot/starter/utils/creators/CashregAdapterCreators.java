package com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.creators;

import com.rbkmoney.damsel.cashreg.adapter.*;
import com.rbkmoney.damsel.cashreg.base.Timer;
import com.rbkmoney.damsel.cashreg.receipt.ReceiptInfo;
import com.rbkmoney.damsel.domain.Failure;

public class CashregAdapterCreators {

    public static Intent createFinishIntentSuccess() {
        return Intent.finish(new FinishIntent(createFinishStatusSuccess()));
    }

    public static Intent createFinishIntentFailure(Failure failure) {
        return Intent.finish(new FinishIntent(createFinishStatusFailure(failure)));
    }

    public static FinishStatus createFinishStatusSuccess() {
        return FinishStatus.success(new Success());
    }

    public static FinishStatus createFinishStatusFailure(Failure failure) {
        return FinishStatus.failure(failure);
    }

    public static Failure createFailure(String code) {
        return createFailure(code, code);
    }

    public static Failure createFailure(String code, String reason) {
        return new Failure().setCode(code).setReason(reason);
    }

    public static CashregResult createCashRegResult(Intent intent, byte[] state, ReceiptInfo info) {
        return new CashregResult().setIntent(intent).setInfo(info).setState(state);
    }

    public static Intent createIntentWithSleepIntent(Integer timer) {
        return Intent.sleep(createSleepIntent(createTimerTimeout(timer)));
    }

    public static SleepIntent createSleepIntent(Timer timer) {
        return new SleepIntent(timer);
    }

    public static Timer createTimerTimeout(Integer timeout) {
        return Timer.timeout(timeout);
    }

}
