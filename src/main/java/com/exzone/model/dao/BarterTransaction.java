package com.exzone.model.dao;

import com.exzone.enums.AcceptanceStatus;
import com.exzone.enums.ExchangeType;
import com.exzone.enums.TransactionStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "barter_transactions")
public class BarterTransaction extends BaseModel {

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    /**
     * This is the product the consumer selected/created, that is the consumer that initiated this transaction
     */
    @NotNull
    @ManyToOne
    @JsonProperty("user_product")
    private BarterProduct userProduct;

    @NotNull
    @JsonProperty("exchange_type")
    @Enumerated(EnumType.STRING)
    private ExchangeType exchangeType;

    /**
     * This is the product the consumer 'paired with' / 'requested for'
     */
    @NotNull
    @ManyToOne
    @JsonProperty("requested_product")
    private BarterProduct requestedProduct;

    /**
     * This specify the channel (mobile, frontend-web, backend-web, etc) through which the transaction occur
     */
    @NotNull
    @ManyToOne
    @JsonProperty("payment_channel")
    private PaymentChannel paymentChannel;

    @NotNull
    @JsonProperty("acceptance_status")
    private AcceptanceStatus acceptanceStatus = AcceptanceStatus.PENDING;

    @NotNull
    @JsonProperty("transaction_status")
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;
}