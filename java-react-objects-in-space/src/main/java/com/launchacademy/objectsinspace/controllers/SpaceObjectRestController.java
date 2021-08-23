package com.launchacademy.objectsinspace.controllers;

import com.launchacademy.objectsinspace.models.SpaceObject;
import com.launchacademy.objectsinspace.repositories.SpaceObjectRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/spaces")
public class SpaceObjectRestController {

  @Autowired
  private SpaceObjectRepository spaceRepo;

  @GetMapping
  public Page<SpaceObject> getListOfSpaces(Pageable pageable) {
    return spaceRepo.findAll(pageable);
  }

  @PostMapping
  public ResponseEntity create(@Valid @RequestBody SpaceObject space, BindingResult result){
    if (result.hasErrors()) {
      return new ResponseEntity<List>(result.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    } else {
      return new ResponseEntity<SpaceObject>(spaceRepo.save(space),HttpStatus.CREATED);
    }
  }

}
