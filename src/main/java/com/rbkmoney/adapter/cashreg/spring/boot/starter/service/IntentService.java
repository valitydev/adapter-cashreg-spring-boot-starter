package com.rbkmoney.adapter.cashreg.spring.boot.starter.service;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.damsel.cashreg.adapter.Intent;

import java.time.Instant;

public interface IntentService {
    Intent getFailureByCode(ExitStateModel exitStateModel);

    Intent getFailureByCodeAndDesc(ExitStateModel exitStateModel);

    Intent getSuccess(ExitStateModel exitStateModel);

    Intent getSleep(ExitStateModel exitStateModel);

    Instant extractMaxDateTimeInstant(EntryStateModel entryStateModel);
}
