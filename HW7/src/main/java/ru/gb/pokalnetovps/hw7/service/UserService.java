package ru.gb.pokalnetovps.hw7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw7.repository.UsersRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UsersRepository userRepository;

    public List getUsers() {

        return userRepository.findAll();
    }
}
