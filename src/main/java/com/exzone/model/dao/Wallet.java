package com.exzone.model.dao;

import com.exzone.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "wallet")
@ToString
public class Wallet extends BaseModel {

    private double amount = 0.00;

    @NotNull
    @ManyToOne
    private Consumer consumer;

    @NotNull
    @ManyToOne
    private Currency currency;

}