package com.exzone.model.dao;

import com.exzone.enums.Initiator;
import com.exzone.enums.TransactionStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction extends BaseModel {

    @NotNull
    private Initiator initiator;

    @Column(length = 100)
    @JsonProperty("channel_reference")
    private String channelReference;

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    @NotNull
    @Column(length = 50)
    @JsonProperty("customer_id")
    private String customerId;

    @NotNull
    private TransactionStatus status = TransactionStatus.PENDING;

    @NotNull
    @Column(precision=20, scale=4)
    private Double amount;

    @NotNull
    @Column(precision=20, scale=4)
    @JsonProperty("amount_paid")
    private Double amountPaid;

    @NotNull
    @JsonProperty("biller_discount")
    private Double billerDiscount;

    @NotNull
    @Column(precision=20, scale=4)
    private Double surcharge;

    @NotNull
    private Double vat;

    @NotNull
    @Column(length = 11)
    private Integer quantity;

    @JsonProperty("date_paid")
    private Date date_paid;

    @JsonProperty("date_reversed")
    private Date dateReversed;

    @JsonProperty("date_settled")
    private Date dateSettled;

    @NotNull
    @ManyToOne
    private BarterProduct barterProduct;

    @ManyToOne
    private Consumer consumer;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Staff staff;

    @NotNull
    @ManyToOne
    private Currency currency;
}