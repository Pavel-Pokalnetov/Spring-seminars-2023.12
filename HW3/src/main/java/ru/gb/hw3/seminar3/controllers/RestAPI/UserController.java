package ru.gb.hw3.seminar3.controllers.RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.repository.UsersRepository;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    UsersRepository usersRepository;

    @GetMapping
    public List<User> users() {
        return usersRepository.getUsers();
    }
}




