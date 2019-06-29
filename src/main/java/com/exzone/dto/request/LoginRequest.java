package com.exzone.dto.request;

import com.exzone.model.dao.Login;
import com.exzone.util.ObjectMapperUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class LoginRequest extends RequestBody<Login>{

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Override
    public Login buildModel() {
        return ObjectMapperUtil.map(this, Login.class);
    }

    @Override
    public Login buildModel(Login login) {
        return ObjectMapperUtil.map(this, login);
    }
}