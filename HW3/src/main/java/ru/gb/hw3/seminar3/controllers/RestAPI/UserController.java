package ru.gb.hw3.seminar3.controllers.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.repository.UsersRepository;
import ru.gb.hw3.seminar3.services.RegistrationService;
import ru.gb.hw3.seminar3.services.UserService;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/users")
    public List<User> users() {
        try {
            return usersRepository.getUsers();
        }catch (DataAccessException e){
            return new ArrayList<>();
        }
    }

    @PostMapping("/users/body")
    public String createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        if (registrationService.processRegistration(name,age,email)) return "{\"result\":\"success\"}";
        return "{\"result\":\"failed\"}";
    }
}




