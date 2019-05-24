package com.exzone.repository.dao;

import com.exzone.model.dao.BarterProduct;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BarterProductRepository extends BaseRepository<BarterProduct, Long> {
}