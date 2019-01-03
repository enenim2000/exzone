package com.exzone.embeddable;

import com.exzone.model.dao.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@ToString
public class Amount{

    @NotNull
    @ManyToOne
    @JsonProperty("transaction_currency")
    private Currency transactionCurrency;

    @NotNull
    private Double amount;
}
