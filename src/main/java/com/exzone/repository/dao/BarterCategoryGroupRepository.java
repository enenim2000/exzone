package com.exzone.repository.dao;

import com.exzone.model.dao.BarterCategoryGroup;
import com.exzone.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BarterCategoryGroupRepository extends BaseRepository<BarterCategoryGroup, Long> {
}