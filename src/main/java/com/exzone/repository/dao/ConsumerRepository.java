package com.exzone.repository.dao;

import com.exzone.model.dao.Consumer;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ConsumerRepository extends BaseRepository<Consumer, Long> {
}