package com.exzone.model.dao;


import com.exzone.enums.EnabledStatus;
import com.exzone.enums.ExchangeType;
import com.exzone.enums.PurchaseStatus;
import com.exzone.enums.WorthStatus;
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
@Table(name = "barter_products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"owner_id", "code"}),
        @UniqueConstraint(columnNames = {"owner_id", "name"})
})
public class BarterProduct extends BaseModel {

    @NotNull
    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String code;

    @NotNull
    @Column(unique = true, length = 200)
    private String slug;

    @NotNull
    private String description;

    /**
     * This holds comma-separated image url for larger images of product
     */
    @NotNull
    String images;

    /**
     * This holds a thumbnail image url of the product
     */
    @NotNull
    @JsonProperty("product_banner")
    private String productBanner;

    @NotNull
    @JsonProperty("currency_worth")
    private Double currencyWorth;

    @NotNull
    @JsonProperty("worth_status")
    @Enumerated(EnumType.STRING)
    private WorthStatus worthStatus = WorthStatus.NON_NEGOTIABLE;

    @NotNull
    @JsonProperty("purchase_status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus = PurchaseStatus.AVAILABLE;

    @NotNull
    @JsonProperty("exchange_type")
    @Enumerated(EnumType.STRING)
    private ExchangeType exchangeType;

    @NotNull
    @JsonProperty("exchange_type_description")
    private String exchangeTypeDescription;

    /**
     * This holds (product category id / currency id) based on the exchange type selected
     */
    @NotNull
    @JsonProperty("exchange_type_id")
    private Long exchangeTypeId;

    @NotNull
    @Column(precision=20, scale=4)
    private Double surcharge;

    @NotNull
    private Double vat;

    private int priority = 0;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @NotNull
    @ManyToOne
    private Consumer owner =  new Consumer();

    /**
     * This holds the actual currency the worth currency is expressed
     */
    @NotNull
    @ManyToOne
    private Currency currency = new Currency();

    @JsonBackReference
    @ManyToMany(mappedBy = "barterProducts")
    private Set<BarterCategory> barterCategories = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "barterProduct", fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();
}