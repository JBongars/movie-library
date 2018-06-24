package com.springboot.movielibrary.movielibrary.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("app")
public class ClientController {

    @RequestMapping("/")
    public String app(){
        return "this is the client";
    }
}