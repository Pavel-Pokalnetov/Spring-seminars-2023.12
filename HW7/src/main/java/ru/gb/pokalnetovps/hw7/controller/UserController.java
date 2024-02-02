package ru.gb.pokalnetovps.hw7.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/public-data")
    public String userProfile() {
        return "Welcome to Public Profile";
    }

    @GetMapping("/private-data")
    public String adminProfile() {
        return "Welcome to Private Profile";
    }

}
