package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "currencies")
public class Currency extends BaseModel {

    @NotNull
    @Column(unique = true, length = 10)
    private String code;

    @NotNull
    @Column(unique = true, length = 100)
    private String name = "";

    @NotNull
    @Column(unique = true, length = 10)
    private String html;

    /**
     * This value is relative to base currency, which is dollar
     * The value of base (dollar) is 1
     */
    @NotNull
    @Column(precision=20, scale=2)
    @JsonProperty("exchange_rate")
    private double exchangeRate;

    @NotNull
    @Column(precision=20, scale=2)
    @JsonProperty("processor_fee")
    private double processorFee;

    @NotNull
    @Column(precision=20, scale=2)
    private double surcharge = 0.00;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;
}