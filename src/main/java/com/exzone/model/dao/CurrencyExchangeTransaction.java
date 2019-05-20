package com.exzone.model.dao;

import com.exzone.enums.PaymentStatus;
import com.exzone.enums.SettlementStatus;
import com.exzone.enums.TransactionStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "currency_exchange_transactions")
public class CurrencyExchangeTransaction extends BaseModel {

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    @NotNull
    @JsonProperty("source_currency_processor_reference")
    private double sourceCurrencyProcessorReference;

    @NotNull
    @JsonProperty("destination_currency_processor_reference")
    private double destinationCurrencyProcessorReference;

    @NotNull
    @JsonProperty("source_currency_processor_name")
    private double sourceCurrencyProcessorName;

    @NotNull
    @JsonProperty("destination_currency_processor_name")
    private double destinationCurrencyProcessorName;

    @NotNull
    @JsonProperty("source_currency_processor_fee")
    private double sourceCurrencyProcessorFee;

    @NotNull
    @JsonProperty("destination_currency_processor_fee")
    private double destinationCurrencyProcessorFee;

    @NotNull
    @JsonProperty("source_currency_surcharge")
    private double sourceCurrencySurcharge = 0.00;

    @NotNull
    @JsonProperty("destination_currency_surcharge")
    private double destinationCurrencySurcharge = 0.00;

    /**
     * This is destination_currency.exchange_rate/source_currency.exchange_rate calculated as at the time of transaction
     */
    @NotNull
    @JsonProperty("exchange_rate")
    private double exchangeRate;

    /**
     * This is in source currency
     */
    @NotNull
    @JsonProperty("transaction_amount")
    private double transactionAmount;

    /**
     * (source_currency_processor_fee + surcharge + transaction_amount) all in source currency
     * This amount is sent to the payment gateway configured to handle debiting for the selected source currency
     */
    @NotNull
    @JsonProperty("source_currency_amount_debited")
    private double sourceCurrencyAmountDebited;

    /**
     * (destination_currency_processor_fee + surcharge + transaction_amount) all in destination currency
     * This amount is sent to the payment gateway configured to handle debiting for the selected destination currency
     */
    @NotNull
    @JsonProperty("destination_currency_amount_debited")
    private double destinationCurrencyAmountDebited;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("source_currency_payment_status")
    private PaymentStatus sourceCurrencyPaymentStatus = PaymentStatus.NOT_PAID;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("destination_currency_payment_status")
    private PaymentStatus destinationCurrencyPaymentStatus = PaymentStatus.NOT_PAID;

    @JsonProperty("source_currency_payment_date")
    private Date sourceCurrencyPaymentDate;

    @JsonProperty("destination_currency_payment_date")
    private Date destinationCurrencyPaymentDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("source_currency_settlement_status")
    private SettlementStatus sourceCurrencySettlementStatus = SettlementStatus.NOT_SETTLED;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("destination_currency_settlement_status")
    private SettlementStatus destinationCurrencySettlementStatus = SettlementStatus.NOT_SETTLED;

    @JsonProperty("source_currency_settlement_date")
    private Date sourceCurrencySettlementDate;

    @JsonProperty("destination_currency_settlement_date")
    private Date destinationCurrencySettlementDate;

    @JsonProperty("source_currency_date_reversed")
    private Date sourceCurrencyDateReversed;

    @JsonProperty("destination_currency_date_reversed")
    private Date destinationCurrencyDateReversed;

    /**
     * This should be retrieved from the user logged-in token
     */
    @NotNull
    @ManyToOne
    @JsonProperty("source_currency_consumer")
    private Consumer sourceCurrencyConsumer;

    /**
     * This should be retrieved from the user logged-in token
     */
    @NotNull
    @ManyToOne
    @JsonProperty("destination_currency_consumer")
    private Consumer destinationCurrencyConsumer;

    /**
     * This is the configured base currency as at the time of transaction
     */
    @NotNull
    @ManyToOne
    @JsonProperty("base_currency")
    private Currency baseCurrency;

    @NotNull
    @ManyToOne
    @JsonProperty("source_currency")
    private Currency sourceCurrency;

    @NotNull
    @ManyToOne
    @JsonProperty("destination_currency")
    private Currency destinationCurrency;

    @NotNull
    @ManyToOne
    @JsonProperty("payment_channel")
    private PaymentChannel paymentChannel;

    @NotNull
    @JsonProperty("transaction_status")
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;
}