package com.launchacademy.objectsinspace.repositories;

import com.launchacademy.objectsinspace.models.SpaceObject;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpaceObjectRepository extends PagingAndSortingRepository<SpaceObject, Integer> {

}
