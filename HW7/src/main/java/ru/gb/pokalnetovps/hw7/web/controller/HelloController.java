package ru.gb.pokalnetovps.hw7.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.pokalnetovps.hw7.service.UserService;

@RestController
public class HelloController {
    @Autowired
    UserService us;

    @GetMapping("/private-data")
    public String helloController() {
        return "Hello, Admin!";
    }

    @GetMapping("/public-data")
    public String helloUser() {
        return "Hello, user!";

    }

}
