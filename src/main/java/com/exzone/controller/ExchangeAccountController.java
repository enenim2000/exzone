package com.exzone.controller;

import com.exzone.annotation.Get;
import com.exzone.annotation.Permission;
import com.exzone.annotation.Role;
import com.exzone.constant.RoleConstant;
import com.exzone.dto.response.PageResponse;
import com.exzone.dto.response.Response;
import com.exzone.model.dao.ExchangeAccount;
import com.exzone.repository.dao.ExchangeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/exchange-account")
public class ExchangeAccountController {

    @Autowired
    private ExchangeAccountRepository exchangeAccountRepository;

    @Get
    @Role({RoleConstant.STAFF})
    @Permission("exchange-account.index")
    public Response<PageResponse<ExchangeAccount>> getExchangeAccount(HttpServletRequest request){
        return new Response<>(new PageResponse<>());
    }

}
