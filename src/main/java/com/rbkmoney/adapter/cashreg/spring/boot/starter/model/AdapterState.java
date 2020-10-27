package com.rbkmoney.adapter.cashreg.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.rbkmoney.adapter.common.model.PollingInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdapterState {

    private Step nextStep;

    @JsonProperty(value = "cashreg_id")
    private String cashregId;

    @JsonProperty(value = "receipt_id")
    private String receiptId;

    @JsonUnwrapped
    private PollingInfo pollingInfo;

}
