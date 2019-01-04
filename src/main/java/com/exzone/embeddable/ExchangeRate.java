package com.exzone.embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Embeddable
public class ExchangeRate {

    @NotNull
    @JsonProperty("source_value")
    private Double sourceValue = 1.00;

    @NotNull
    @JsonProperty("destination_value")
    private Double destinationValue;
}
