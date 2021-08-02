package com.spring.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/")
    public String homePage() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "<h1>Welcome ADMIN</h1>";
    }

    @GetMapping("/user")
    public String userPage() {
        return "<h1>Welcome USER</h1>";
    }
}
