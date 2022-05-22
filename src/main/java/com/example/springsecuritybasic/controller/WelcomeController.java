package com.example.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/secured")
    public String apiOne() {
        return "Hello, You have been authenticated";
    }

    @GetMapping("/not-secured")
    public String apiTwo() {
        return "success without authentication";
    }
}
