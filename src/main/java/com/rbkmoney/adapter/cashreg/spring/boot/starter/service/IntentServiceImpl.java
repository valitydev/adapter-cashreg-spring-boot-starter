package com.rbkmoney.adapter.cashreg.spring.boot.starter.service;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties.TimerProperties;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.damsel.cashreg.base.Timer;
import com.rbkmoney.damsel.cashreg.provider.*;
import com.rbkmoney.error.mapping.ErrorMapping;
import com.rbkmoney.java.damsel.utils.extractors.OptionsExtractors;
import lombok.RequiredArgsConstructor;

import java.time.Instant;


/**
 * Usage example:
 *
 * <pre>
 * {@code
 *      IntentServiceImpl intentService = new IntentServiceImpl(errorMapping, timerProperties);
 *      Intent intent = intentService.getFailureByCode(exitStateModel);
 * }
 * </pre>
 */
@RequiredArgsConstructor
public class IntentServiceImpl implements IntentService {

    private final ErrorMapping errorMapping;
    private final TimerProperties timerProperties;

    public Intent getFailureByCode(ExitStateModel exitStateModel) {
        return Intent.finish(new FinishIntent(FinishStatus.failure(errorMapping.mapFailure(exitStateModel.getErrorCode()))));
    }

    public Intent getFailureByCodeAndDesc(ExitStateModel exitStateModel) {
        return Intent.finish(new FinishIntent(FinishStatus.failure(errorMapping.mapFailure(exitStateModel.getErrorCode(), exitStateModel.getErrorMessage()))));
    }

    public Intent getSuccess(ExitStateModel exitStateModel) {
        return Intent.finish(new FinishIntent(FinishStatus.success(new Success())));
    }

    public Intent getSleep(ExitStateModel exitStateModel) {
        if (exitStateModel.getAdapterContext().getMaxDateTimePolling() == null) {
            throw new IllegalArgumentException("Need to specify 'maxTimePoolingMillis' before sleep");
        }
        if (exitStateModel.getAdapterContext().getMaxDateTimePolling().getEpochSecond() < Instant.now().getEpochSecond()) {
            return Intent.finish(new FinishIntent(FinishStatus.failure(errorMapping.mapFailure(
                    com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.SLEEP_TIMEOUT.getCode(),
                    com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.SLEEP_TIMEOUT.getMessage()
            ))));
        }

        int timerPollingDelay = OptionsExtractors.extractPollingDelay(exitStateModel.getEntryStateModel().getOperationModel().getOptions(), timerProperties.getPollingDelay());
        return Intent.sleep(new SleepIntent(new Timer(Timer.timeout(timerPollingDelay))));
    }

}
