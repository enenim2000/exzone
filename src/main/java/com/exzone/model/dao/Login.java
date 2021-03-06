package com.exzone.model.dao;

import com.exzone.enums.LoginStatus;
import com.exzone.enums.UserType;
import com.exzone.enums.VerifyStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "logins")
@ToString
public class Login extends BaseModel {

    @NotNull
    @Column(unique = true, length = 70)
    private String username;

    @Column
    private String password;

    @NotNull
    @Column(length = 50)
    @JsonProperty("user_type")
    private UserType userType;

    @NotNull
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("last_logged_in")
    private Date lastLoggedIn;

    @NotNull
    private LoginStatus status = LoginStatus.ENABLED;

    @NotNull
    private VerifyStatus verifyStatus = VerifyStatus.NOT_VERIFIED;

    @JsonBackReference
    @OneToMany(mappedBy = "login", fetch = FetchType.LAZY)
    private Set<Audit> audits = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "login", fetch = FetchType.LAZY)
    private Set<Notification> notifications  = new HashSet<>();
}
