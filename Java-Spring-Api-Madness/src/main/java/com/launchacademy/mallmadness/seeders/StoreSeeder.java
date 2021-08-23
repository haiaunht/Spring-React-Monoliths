package com.launchacademy.mallmadness.seeders;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StoreSeeder implements CommandLineRunner {
  private StoreRepository storeRepository;

  @Autowired
  public StoreSeeder(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }


  @Override
  public void run(String... args) throws Exception {
    Store allderwood = new Store();
    allderwood.setName("Allderwood");
    allderwood.setType("mall");
    allderwood.setAverageCost(4);
    allderwood.setOperatingStatus(true);

    Store target = new Store();
    target.setName("Target");
    target.setType("store");
    target.setAverageCost(3);
    target.setOperatingStatus(false);

    List<Store> storeList = (List<Store>) storeRepository.findAll();
    if (storeList.size() == 0) {
      storeRepository.save(allderwood);
      storeRepository.save(target);
    }
  }
}
