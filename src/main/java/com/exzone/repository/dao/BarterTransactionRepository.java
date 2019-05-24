package com.exzone.repository.dao;

import com.exzone.model.dao.BarterTransaction;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BarterTransactionRepository extends BaseRepository<BarterTransaction, Long> {
}