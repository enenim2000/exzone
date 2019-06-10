package com.exzone.dto.request;

import com.exzone.model.dao.Consumer;
import com.exzone.util.ObjectMapperUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class ConsumerRequest extends RequestBody<Consumer>{

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @JsonProperty("confirm_password")
    private String confirmPassword;

    @Override
    public Consumer buildModel() {
        return ObjectMapperUtil.map(this, Consumer.class);
    }

    @Override
    public Consumer buildModel(Consumer consumer) {
        return ObjectMapperUtil.map(this, consumer);
    }
}