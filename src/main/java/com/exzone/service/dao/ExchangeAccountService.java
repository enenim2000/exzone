package com.exzone.service.dao;

import com.exzone.model.dao.ExchangeAccount;
import com.exzone.repository.dao.ExchangeAccountRepository;
import com.exzone.util.PageRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeAccountService{
    private final ExchangeAccountRepository exchangeAccountRepository;

    @Autowired
    public ExchangeAccountService(ExchangeAccountRepository exchangeAccountRepository) {
        this.exchangeAccountRepository = exchangeAccountRepository;
    }

    public Page<ExchangeAccount> getExchangeAccounts(){
        return exchangeAccountRepository.findAll(PageRequestUtil.getPageRequest());
    }

    public List<ExchangeAccount> getConsumerExchangeAccounts(Long consumerId){
        return exchangeAccountRepository.findConsumerExchangeAccounts(consumerId);
    }

    public ExchangeAccount getExchangeAccount(Long id){
        return exchangeAccountRepository.findOrFail(id);
    }

    public ExchangeAccount saveExchangeAccount(ExchangeAccount exchangeAccount){
        return exchangeAccountRepository.save(exchangeAccount);
    }
}