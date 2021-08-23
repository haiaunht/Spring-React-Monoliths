package com.launchacademy.mallmadness.services;

import com.launchacademy.mallmadness.dtos.StoreDto;
import com.launchacademy.mallmadness.mappers.StoreMapper;
import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
  private final StoreRepository storeRepository;
  private final StoreMapper storeMapper;

  @Autowired
  public StoreService(StoreRepository storeRepository,
      StoreMapper storeMapper) {
    this.storeRepository = storeRepository;
    this.storeMapper = storeMapper;
  }

  public Page<StoreDto> findAll(Pageable pageable) {
    Page<Store> page = storeRepository.findAll(pageable);
    return new PageImpl<StoreDto>(storeMapper.storesToStoreDtos(page.getContent()), pageable, page.getTotalElements());
  }
}
