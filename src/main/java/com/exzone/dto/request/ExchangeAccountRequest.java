package com.exzone.dto.request;

import com.exzone.enums.AccountType;
import com.exzone.model.dao.ExchangeAccount;
import com.exzone.util.ObjectMapperUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeAccountRequest extends RequestBody<ExchangeAccount>{

    @NotBlank
    @JsonProperty("account_name")
    private String accountName;

    @NotBlank
    @JsonProperty("account_number")
    private String accountNumber;

    @NotBlank
    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("sort_code")
    private String sortCode;

    @JsonProperty("country_code")
    private String countryCode;

    @NotBlank
    @JsonProperty("account_type")
    private AccountType accountType;

    @NotBlank
    @JsonProperty("currency_id")
    private Long currencyId;

    @NotBlank
    @JsonProperty("consumer_id")
    private Long consumerId;

    @Override
    public ExchangeAccount buildModel() {
        return ObjectMapperUtil.map(this, ExchangeAccount.class);
    }

    @Override
    public ExchangeAccount buildModel(ExchangeAccount exchangeAccount) {
        return ObjectMapperUtil.map(this, exchangeAccount);
    }
}