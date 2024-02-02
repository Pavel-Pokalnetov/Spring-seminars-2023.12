package ru.gb.pokalnetovps.hw7.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/public-data/**")
    public ResponseEntity<String> userProfile() {
        return new ResponseEntity<String>("Welcome to Public Profile", HttpStatus.ACCEPTED);
    }

    @GetMapping("/private-data/**")
    public ResponseEntity<String> adminProfile() {
        return new ResponseEntity<String>("Welcome to Public Profile", HttpStatus.ACCEPTED);
    }

}
