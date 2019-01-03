package com.exzone.model.dao;

import com.exzone.embeddable.Amount;
import com.exzone.enums.Initiator;
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

    @JsonProperty("date_paid")
    private Date date_paid;

    @JsonProperty("date_reversed")
    private Date dateReversed;

    @JsonProperty("date_settled")
    private Date dateSettled;

    @Embedded
    private Amount amount;

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