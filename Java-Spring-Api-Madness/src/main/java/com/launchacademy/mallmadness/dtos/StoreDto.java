package com.launchacademy.mallmadness.dtos;

import com.launchacademy.mallmadness.models.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreDto {
  private Integer id;
  private String name;
  private String type;
  //private Integer averageCost;
  //convert from int -> string
  private String averageCostToString;
  private Boolean operatingStatus;

  public static StoreDto fromStore(Store store) {
    StoreDto storeDto = new StoreDto();
    storeDto.setName(store.getName());
    storeDto.setType(store.getType());

    if (store.getAverageCost() == 1) {
      storeDto.setAverageCostToString("Bargain");
    } else if (store.getAverageCost() == 2) {
      storeDto.setAverageCostToString("Good Deals");
    } else if (store.getAverageCost() == 3) {
      storeDto.setAverageCostToString("Good Value");
    } else if (store.getAverageCost() == 4) {
      storeDto.setAverageCostToString("Pricey but Worth it");
    } else if (store.getAverageCost() == 5) {
      storeDto.setAverageCostToString("Upscale");
    }
    storeDto.setOperatingStatus(store.getOperatingStatus());
    return storeDto;
  }
}
