package com.launchacademy.mallmadness.mappers;

import com.launchacademy.mallmadness.dtos.StoreDto;
import com.launchacademy.mallmadness.models.Store;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface StoreMapper {
  @Mapping(target = "averageCostToString", source = "averageCost")
  @Mapping(target = "id", ignore = true)
  StoreDto storeToStoreDto(Store store);
  List<StoreDto> storesToStoreDtos(List<Store> stores);
}
