package com.exzone.model.dao;

import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "exchange_request")
@ToString
public class ExchangeRequest extends BaseModel {

    @NotNull
    private double rate;

    @NotNull
    private double amount;

    @NotNull
    @ManyToOne
    private Consumer consumer;

    @NotNull
    @ManyToOne
    @JsonProperty("source_currency")
    private Currency sourceCurrency;

    @NotNull
    @ManyToOne
    @JsonProperty("destination_currency")
    private Currency destinationCurrency;
}