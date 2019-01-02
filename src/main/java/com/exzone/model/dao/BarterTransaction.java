package com.exzone.model.dao;

import com.exzone.enums.AcceptanceStatus;
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
@Table(name = "barter_transactions")
public class BarterTransaction extends BaseModel {

    @NotNull
    private Initiator initiator;

    @Column(length = 100)
    @JsonProperty("channel_reference")
    private String channelReference;

    @NotNull
    @Column(unique = true, length = 50)
    @JsonProperty("transaction_reference")
    private String transactionReference;

    @JsonProperty("date_consummated")
    private Date date_consummated;

    @NotNull
    @JsonProperty("acceptance_status")
    private AcceptanceStatus acceptanceStatus = AcceptanceStatus.PENDING;

    @NotNull
    @JsonProperty("transaction_status")
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    /**
     * This is the product the consumer selected
     */
    @NotNull
    @ManyToOne
    @JsonProperty("barter_product")
    private BarterProduct barterProduct;

    /**
     * This holds the (product/currency) to be exchanged with the selected barter product
     */
    @NotNull
    @JsonProperty("exchange_type_id")
    private Long  exchangeTypeId;
}