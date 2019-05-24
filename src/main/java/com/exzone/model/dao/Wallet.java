package com.exzone.model.dao;

import com.exzone.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "wallet", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"consumer_id", "currency_id"})
})
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