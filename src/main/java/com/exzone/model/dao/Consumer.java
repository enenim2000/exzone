package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.enums.VerifyStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "consumers")
public class Consumer extends BaseModel {

    @JsonProperty("first_name")
    @SerializedName("first_name")
    @Column(length = 30)
    private String firstName;

    @JsonProperty("last_name")
    @SerializedName("last_name")
    @Column(length = 30)
    private String lastName;

    @JsonProperty("email")
    @SerializedName("email")
    @Column(unique = true, length = 100)
    private String email;

    @JsonProperty("phone_number")
    @SerializedName("phone_number")
    @Column(length = 30)
    private String phoneNumber;

    private VerifyStatus verified = VerifyStatus.NOT_VERIFIED;

    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @JsonBackReference
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<BarterProduct> barterProducts = new HashSet<>();
}
