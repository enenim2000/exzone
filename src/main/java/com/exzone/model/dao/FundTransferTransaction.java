package com.exzone.model.dao;

import com.exzone.enums.Initiator;
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
@Table(name = "fund_transfer_transactions")
public class FundTransferTransaction extends BaseModel {

    @NotNull
    private Initiator initiator;

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    /**
     * This is the configured processor fee as at the time of transaction
     */
    @NotNull
    @JsonProperty("processor_fee")
    private double processorFee;

    /**
     * This is the configured charge as at the time of transaction
     */
    @NotNull
    private double surcharge = 0.00;

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
     * (processor_fee + surcharge + transaction_amount) all in source currency
     * This amount is sent to the payment gateway configured to handle debiting for the selected source currency
     */
    @NotNull
    @JsonProperty("amount_debited")
    private double amountDebited;

    /**
     * This amount is converted to destination currency using the formula below
     * (transaction_amount) in source currency * (exchange_rate) calculated above
     */
    @NotNull
    @JsonProperty("amount_credited")
    private double amountCredited;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    @JsonProperty("payment_date")
    private Date paymentDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("settlement_status")
    private SettlementStatus settlementStatus = SettlementStatus.NOT_SETTLED;

    @JsonProperty("settlement_date")
    private Date settlementDate;

    @JsonProperty("date_reversed")
    private Date dateReversed;

    /**
     * This should be retrieved from the user logged in token
     */
    @NotNull
    @ManyToOne
    @JsonProperty("consumer")
    private Consumer consumer;

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