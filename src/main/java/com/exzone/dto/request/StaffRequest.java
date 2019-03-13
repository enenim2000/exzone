package com.exzone.dto.request;

import com.exzone.model.dao.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffRequest extends RequestBody<Staff> {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @Override
    Staff buildModel() {
        return null;
    }

    @Override
    Staff buildModel(Staff model) {
        return null;
    }

}
