package com.exzone.repository.dao;

import com.exzone.model.dao.BarterCategory;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BarterCategoryRepository extends BaseRepository<BarterCategory, Long> {
}