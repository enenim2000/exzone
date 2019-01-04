package com.exzone.model.dao;

import com.exzone.embeddable.Amount;
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
@Table(name = "barter_transactions")
public class FundTransferTransaction extends BaseModel {

    @NotNull
    private Initiator initiator;

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    @Embedded
    private Amount amount;

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