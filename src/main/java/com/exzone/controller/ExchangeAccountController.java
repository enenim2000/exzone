package com.exzone.controller;

import com.exzone.annotation.*;
import com.exzone.constant.RoleConstant;
import com.exzone.dto.request.ExchangeAccountRequest;
import com.exzone.dto.response.CollectionResponse;
import com.exzone.dto.response.ModelResponse;
import com.exzone.dto.response.PageResponse;
import com.exzone.dto.response.Response;
import com.exzone.model.dao.ExchangeAccount;
import com.exzone.service.dao.ExchangeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange-accounts")
public class ExchangeAccountController {

    private final ExchangeAccountService exchangeAccountService;

    @Autowired
    public ExchangeAccountController(ExchangeAccountService exchangeAccountService) {
        this.exchangeAccountService = exchangeAccountService;
    }

    @Get
    @Role({RoleConstant.STAFF})
    @Permission("exchange-account.index")
    public Response<PageResponse<ExchangeAccount>> getExchangeAccounts(){
        return new Response<>(new PageResponse<>(exchangeAccountService.getExchangeAccounts()));
    }

    @Get("/{id}")
    @Role({RoleConstant.STAFF})
    @Permission("exchange-account.index.consumer")
    public Response<CollectionResponse<ExchangeAccount>> getConsumerExchangeAccounts(@PathVariable Long id){
        return new Response<>(new CollectionResponse<>( exchangeAccountService.getConsumerExchangeAccounts(id)) );
    }

    @Get("/{id}")
    @Role({RoleConstant.STAFF, RoleConstant.CONSUMER})
    @Permission("exchange-account.show")
    public Response<ModelResponse<ExchangeAccount>> getExchangeAccount(@PathVariable Long id){
        return new Response<>(new ModelResponse<>(exchangeAccountService.getExchangeAccount(id)));
    }

    @Post
    @Role({RoleConstant.STAFF, RoleConstant.CONSUMER})
    @Permission("exchange-account.create")
    public Response<ModelResponse<ExchangeAccount>> createExchangeAccount(@Valid @RequestBody ExchangeAccountRequest request){
        return new Response<>(new ModelResponse<>(
                exchangeAccountService.saveExchangeAccount( request.buildModel() )
        ));
    }

    @Put("/{id}")
    @Role({RoleConstant.STAFF, RoleConstant.CONSUMER})
    @Permission("exchange-account.update")
    public Response<ModelResponse<ExchangeAccount>> updateExchangeAccount(@PathVariable Long id, @Valid @RequestBody ExchangeAccountRequest request){
        return new Response<>(new ModelResponse<>(
                exchangeAccountService.saveExchangeAccount( request.buildModel(exchangeAccountService.getExchangeAccount(id)) )
        ));
    }
}
