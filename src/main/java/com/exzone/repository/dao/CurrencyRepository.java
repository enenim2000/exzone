package com.exzone.repository.dao;

import com.exzone.model.dao.Currency;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CurrencyRepository extends BaseRepository<Currency, Long> {
}