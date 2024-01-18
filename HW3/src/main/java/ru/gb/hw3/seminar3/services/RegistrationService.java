package ru.gb.hw3.seminar3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.repository.UsersRepository;

@Service
public class RegistrationService {
    @Autowired
    UserService userService;
    @Autowired
    UsersRepository usersRepository;

    public boolean processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        return usersRepository.addUser(user);
    }
}
