package com.exzone.repository.dao;

import com.exzone.model.dao.PaymentChannel;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PaymentChannelRepository extends BaseRepository<PaymentChannel, Long> {
}