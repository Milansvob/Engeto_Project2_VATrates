package com.example.Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

//    final MainService mainService;
//
//    public MainController(MainService mainService) {
//        this.mainService = mainService;
//    }

//    @GetMapping(path = "/hello")
//    public String hello() {
//        return mainService.vatCountryList();
//    }

    final Mapper mapper;
    public MainController(Mapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return mapper.parseArrayListToJsonList();
    }
}

