package com.exzone.repository.dao;

import com.exzone.model.dao.ExchangeAccount;
import com.exzone.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ExchangeAccountRepository extends BaseRepository<ExchangeAccount, Long> {

    @Query("select ea from ExchangeAccount ex where ex.consumer.id = ?1")
    List<ExchangeAccount> findConsumerExchangeAccounts(Long consumerId);

}