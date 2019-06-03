package com.exzone.model.dao;


import com.exzone.enums.EnabledStatus;
import com.exzone.enums.ExchangeType;
import com.exzone.enums.PurchaseStatus;
import com.exzone.enums.WorthStatus;
import com.exzone.model.BaseModel;
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
        @UniqueConstraint(columnNames = {"owner_id", "sku"})
})
public class BarterProduct extends BaseModel {

    @NotNull
    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String sku;

    @NotNull
    @Column(unique = true, length = 200)
    private String slug;

    @NotNull
    private String description;

    /**
     * This holds comma-separated image url for larger images of product
     */
    @NotNull
    @JsonProperty("product_image_urls")
    private String productImageUrls;

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
    private ExchangeType exchangeType = ExchangeType.ANY;

    @NotNull
    @JsonProperty("exchange_type_description")
    private String exchangeTypeDescription;

    private int priority = 0;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @NotNull
    @ManyToOne
    private Consumer owner;

    /**
     * This holds the actual currency the worth currency is expressed
     */
    @NotNull
    @ManyToOne
    private Currency currency;

    @NotNull
    @ManyToOne
    @JsonProperty("barter_category")
    private BarterCategory barterCategory;

    @ManyToMany
    @JoinTable(name = "barter_product_payment_channel",
            joinColumns = @JoinColumn(name = "barter_product_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_channel_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"barter_product_id", "payment_channel_id"})
    )
    private Set<PaymentChannel> paymentChannels = new HashSet<>();
}