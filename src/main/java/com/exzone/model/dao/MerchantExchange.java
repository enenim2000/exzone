package com.exzone.model.dao;

import com.exzone.embeddable.ExchangeRate;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "merchant_exchange")
public class MerchantExchange extends BaseModel {

    @NotNull
    @JsonProperty("source_currency")
    private Currency sourceCurrency;

    @NotNull
    @JsonProperty("destination_currency")
    private Currency destinationCurrency;

    @Embedded
    @JsonProperty("exchange_rate")
    private ExchangeRate exchangeRate;

    private Double ratings = 0.00; //4.50

    @NotNull
    @ManyToOne
    private Consumer merchant;

}
