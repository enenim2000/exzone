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
@Table(name = "barter_category_groups")
public class BarterCategoryGroup extends BaseModel {

    @NotNull
    @Column(unique=true, length = 50)
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Column(unique = true, length = 50)
    private String slug;

    private int priority = 0;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @JsonBackReference
    @OneToMany(mappedBy = "barterCategoryGroup", fetch = FetchType.LAZY)
    private Set<BarterCategory> barterCategories = new HashSet<>();
}