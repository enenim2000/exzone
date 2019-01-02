package com.exzone.model.dao;

import com.exzone.enums.EnabledStatus;
import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "barter_categories")
public class BarterCategory extends BaseModel {

    @NotNull
    @Column(unique=true, length = 50)
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Column(unique = true, length = 50)
    private String slug;

    @NotNull
    @Column(length = 40)
    private String icon = "fa fa-circle";

    private int priority = 0;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @NotNull
    @ManyToOne
    @JsonProperty("barter_category_group")
    private BarterCategoryGroup barterCategoryGroup;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "barter_category_product",
            joinColumns = @JoinColumn(name = "barter_category_id"),
            inverseJoinColumns = @JoinColumn(name = "barter_product_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"barter_category_id", "barter_product_id"})
    )
    private Set<BarterProduct> barterProducts = new HashSet<>();
}