package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "staff")
@ToString
public class Staff extends BaseModel{

    @NotNull
    @Column(unique = true, length = 20)
    @JsonProperty("employee_id")
    @SerializedName("employee_id")
    private String employeeId;

    @NotNull
    @Column(length = 60)
    @JsonProperty("fullname")
    @SerializedName("fullname")
    private String fullName;

    @NotNull
    @Column(unique = true, length = 100)
    private String email;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(Long id) {
        super();
        this.setId(id);
    }
}
