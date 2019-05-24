package com.exzone.repository.dao;

import com.exzone.model.dao.Wallet;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WalletRepository extends BaseRepository<Wallet, Long> {
}