package com.exzone.model.dao;

import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message extends BaseModel {

    private Long to;

    private Long from;

    private String message;

    @JsonProperty("transaction_reference")
    private String transactionReference;
}