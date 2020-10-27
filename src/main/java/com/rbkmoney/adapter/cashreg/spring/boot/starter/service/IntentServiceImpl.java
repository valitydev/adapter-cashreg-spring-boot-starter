package com.rbkmoney.adapter.cashreg.spring.boot.starter.service;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties.TimerProperties;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.common.model.PollingInfo;
import com.rbkmoney.adapter.common.utils.times.ExponentialBackOffPollingService;
import com.rbkmoney.damsel.cashreg.adapter.*;
import com.rbkmoney.damsel.cashreg.base.Timer;
import com.rbkmoney.error.mapping.ErrorMapping;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.rbkmoney.java.damsel.utils.extractors.OptionsExtractors.extractMaxTimePolling;
import static com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.SLEEP_TIMEOUT;

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
        Instant maxDateTimePolling = exitStateModel.getAdapterContext().getPollingInfo().getMaxDateTimePolling();
        if (maxDateTimePolling == null) {
            throw new IllegalArgumentException("Need to specify 'maxDateTimePolling' before sleep");
        }
        if (maxDateTimePolling.toEpochMilli() < Instant.now().toEpochMilli()) {
            return prepareFailureIntent();
        }
        int timerPollingDelay = computePollingInterval(exitStateModel);
        return Intent.sleep(new SleepIntent(new Timer(Timer.timeout(timerPollingDelay))));
    }

    private int computePollingInterval(ExitStateModel exitStateModel) {
        ExponentialBackOffPollingService<PollingInfo> pollingService = new ExponentialBackOffPollingService<>();
        return pollingService.prepareNextPollingInterval(
                exitStateModel.getAdapterContext().getPollingInfo(),
                exitStateModel.getEntryStateModel().getOptions()
        );
    }

    private Intent prepareFailureIntent() {
        String code = SLEEP_TIMEOUT.getCode();
        String reason = SLEEP_TIMEOUT.getMessage();
        return Intent.finish(new FinishIntent(FinishStatus.failure(errorMapping.mapFailure(code, reason))));
    }

    public Instant extractMaxDateTimeInstant(EntryStateModel entryStateModel) {
        int maxTimePolling = extractMaxTimePolling(entryStateModel.getOptions(), timerProperties.getMaxTimePolling());
        return Instant.now().plus(maxTimePolling, ChronoUnit.MINUTES);
    }
}
