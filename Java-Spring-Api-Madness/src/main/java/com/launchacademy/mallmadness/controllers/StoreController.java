package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stores")
public class StoreController {

  @Autowired
  private StoreRepository storeRepository;

  @GetMapping
  public String indexPage(Pageable pageable, Model model) {
    model.addAttribute("stores", storeRepository.findAll(pageable));
    return "stores/index";
  }

  @GetMapping("/new")
  public String addNewStoreForm(@ModelAttribute("store") Store store) {
    return "stores/new";
  }

  @PostMapping
  public String createNewStore(@ModelAttribute @Valid Store store,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "stores/new";
    } else {
      storeRepository.save(store);
      return "redirect:/stores";
    }
  }
}
