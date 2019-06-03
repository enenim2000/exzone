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
@Table(name = "branches")
public class Branch extends BaseModel {


    public Branch() {
    }

    public Branch(Long id) {
        super();
        this.setId(id);
    }

    @NotNull
    @Column(unique = true, length = 10)
    private String sol;

    @NotNull
    @Column(length = 200)
    private String name;

    @NotNull
    @Column(length = 200)
    private String address;
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @JsonBackReference
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private Set<Staff> staff = new HashSet<>();

    /*@JsonBackReference
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();*/
}