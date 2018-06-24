package com.springboot.movielibrary.movielibrary.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("app")
public class ClientController extends RootController {

    //Offset to a separate web service

//    @RequestMapping("/welcome")
//    public String welcome(){
//
//        return "this is the client";
//    }
//
//    @RequestMapping("/list")
//    public String app(){
//        return "this is the client";
//    }
}