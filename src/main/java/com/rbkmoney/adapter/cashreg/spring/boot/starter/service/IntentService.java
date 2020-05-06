package com.rbkmoney.adapter.cashreg.spring.boot.starter.service;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.damsel.cashreg.adapter.Intent;

public interface IntentService {
    Intent getFailureByCode(ExitStateModel exitStateModel);

    Intent getFailureByCodeAndDesc(ExitStateModel exitStateModel);

    Intent getSuccess(ExitStateModel exitStateModel);

    Intent getSleep(ExitStateModel exitStateModel);
}
