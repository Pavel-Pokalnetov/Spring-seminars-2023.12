package ru.gb.pokalnetovps.hw7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw7.model.User;
import ru.gb.pokalnetovps.hw7.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    UsersRepository userRepository;

    public List<User> getUsers() {
        return StreamSupport
                .stream(userRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());

    }

    public User getUserByName(String username) {
        return userRepository.findByName(username);
    }
}
