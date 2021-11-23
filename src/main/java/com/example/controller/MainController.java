package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    //localhost:8080/
    @GetMapping
    public String mainController(){
        return "main-page";
    }
}
