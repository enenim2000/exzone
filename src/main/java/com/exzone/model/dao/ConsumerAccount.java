package com.exzone.model.dao;

import com.exzone.enums.AccountType;
import com.exzone.enums.EnabledStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "consumer_accounts", uniqueConstraints = @UniqueConstraint(columnNames = {"currency_id", "consumer_id"}))
public class ConsumerAccount extends BaseModel {
    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_name")
    private String accountName;

    @JsonProperty("email")
    @Column(length = 70)
    private String email;

    @JsonProperty("phoneNumber")
    @Column(length = 15)
    private String phone;

    @JsonProperty("branch_code")
    @Column(length = 6)
    private String branchCode;

    @OneToOne
    private Currency currency;

    @ManyToOne
    private Consumer consumer;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("account_type")
    private AccountType accountType = AccountType.SAVINGS;

    private EnabledStatus enabled = EnabledStatus.ENABLED;
}
