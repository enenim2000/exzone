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
@Table(name = "merchant_exchange_transactions")
public class MerchantExchangeTransaction extends BaseModel {

    @NotNull
    private Initiator initiator;

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    @JsonProperty("consumer_payment_date")
    private Date consumerPaymentDate;

    @JsonProperty("merchant_payment_date")
    private Date merchantPaymentDate;

    @JsonProperty("consumer_settlement_date")
    private Date consumerSettlementDate;

    @JsonProperty("merchant_settlement_date")
    private Date merchantSettlementDate;

    @JsonProperty("consumer_reversal_date")
    private Date consumerReversalDate;

    @JsonProperty("merchant_reversal_date")
    private Date merchantReversalDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("consumer_payment_status")
    private PaymentStatus consumerPaymentStatus = PaymentStatus.NOT_PAID;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("merchant_payment_status")
    private PaymentStatus merchantPaymentStatus = PaymentStatus.NOT_PAID;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("consumer_settlement_status")
    private SettlementStatus consumerSettlementStatus = SettlementStatus.NOT_SETTLED;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("merchant_settlement_status")
    private SettlementStatus merchantSettlementStatus = SettlementStatus.NOT_SETTLED;

    /**
     * This should be retrieved from the user logged in token
     */
    @NotNull
    @ManyToOne
    @JsonProperty("consumer")
    private Consumer consumer;

    @NotNull
    @ManyToOne
    @JsonProperty("merchant_exchange")
    private MerchantExchange merchantExchange;

    @NotNull
    @ManyToOne
    @JsonProperty("payment_channel")
    private PaymentChannel paymentChannel;

    @NotNull
    @JsonProperty("transaction_status")
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;
}