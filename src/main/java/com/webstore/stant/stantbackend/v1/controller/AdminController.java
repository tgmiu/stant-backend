package com.webstore.stant.stantbackend.v1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminController.BASE_URL)
@CrossOrigin
public class AdminController {
    final static String BASE_URL = "/api/v1/admin";


    @GetMapping()
    public String refreshToken() {
        return "Admin Page";
    }

}
