package com.exzone.model.dao;

import com.exzone.enums.Negotiable;
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
    private double rate; //(source_currency.exchangeRate / destination_currency.exchangeRate) is source unit per one destination unit

    @NotNull
    private double amount = 0.00;

    @NotNull
    private Negotiable negotiable = Negotiable.NO;

    @JsonProperty("transaction_reference")
    private String transactionReference;

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