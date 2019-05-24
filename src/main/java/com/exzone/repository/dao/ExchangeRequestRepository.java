package com.exzone.repository.dao;

import com.exzone.model.dao.ExchangeRequest;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExchangeRequestRepository extends BaseRepository<ExchangeRequest, Long> {
}