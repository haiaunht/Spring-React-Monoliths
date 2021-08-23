package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.dtos.StoreDto;
import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import com.launchacademy.mallmadness.services.StoreService;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreRestApiController {

  private StoreRepository storeRepository;
  private StoreService storeService;

  @Autowired
  public StoreRestApiController(
      StoreRepository storeRepository,
      StoreService storeService) {
    this.storeRepository = storeRepository;
    this.storeService = storeService;
  }

//  @GetMapping
//  public Iterable<Store> displayAllStores(@PageableDefault(size = 5) Pageable pageable) {
//    return storeRepository.findAll(pageable);
//  }

  @GetMapping
  public Page<StoreDto> displayAllStore(@PageableDefault(size = 5) Pageable pageable) {
    return storeService.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Store displayAllStores(@PathVariable Integer id) {
    return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException());
  }

  @NoArgsConstructor
  private class StoreNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class UrlNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StoreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(StoreNotFoundException ex) {
      return "No store with this id can be found!!!";
    }
  }
}
