package com.exzone.repository.dao;

import com.exzone.model.dao.ExchangeAccount;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExchangeAccountRepository extends BaseRepository<ExchangeAccount, Long> {
}