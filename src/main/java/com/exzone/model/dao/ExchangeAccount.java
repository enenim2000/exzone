package com.exzone.model.dao;

import com.exzone.enums.AccountType;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "exchange_accounts")
@ToString
/*
 * This class holds the consumer account per currency for consumer settlement purpose
 */
public class ExchangeAccount extends BaseModel {

    @NotNull
    @JsonProperty("account_name")
    private String accountName;

    @NotNull
    @JsonProperty("account_number")
    private String accountNumber;

    @NotNull
    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("sort_code")
    private String sortCode;

    @NotNull
    @JsonProperty("country_code")
    private String countryCode;

    @NotNull
    @JsonProperty("account_type")
    private AccountType accountType;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    private Currency currency;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    private Consumer consumer;
}