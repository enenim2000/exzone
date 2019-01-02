package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "currencies")
public class Currency extends BaseModel {

    @NotNull
    @Column(unique = true, length = 10)
    private String code;

    @NotNull
    @Column(unique = true, length = 100)
    private String name = "";

    @NotNull
    @Column(unique = true, length = 10)
    private String html;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @JsonBackReference
    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    private Set<TransactionDemo> transactionDemos = new HashSet<>();
}