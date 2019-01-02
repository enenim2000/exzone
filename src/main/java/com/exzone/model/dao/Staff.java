package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.enums.HolidayLogin;
import com.exzone.enums.WeekendLogin;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JsonProperty("active_hour")
    @SerializedName("active_hour")
    private ActiveHour activeHour;

    @NotNull
    @Column(length = 60)
    @JsonProperty("fullname")
    @SerializedName("fullname")
    private String fullName;

    @NotNull
    @Column(unique = true, length = 100)
    private String email;

    @JsonProperty("holiday_login")
    @SerializedName("holiday_login")
    private HolidayLogin holidayLogin;

    @JsonProperty("weekend_login")
    @SerializedName("weekend_login")
    private WeekendLogin weekendLogin;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @ManyToOne
    private Branch branch;

    @NotNull
    @ManyToOne
    private Group group;

    @JsonBackReference
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();

    public Staff() {
    }

    public Staff(Long id) {
        super();
        this.setId(id);
    }
}
