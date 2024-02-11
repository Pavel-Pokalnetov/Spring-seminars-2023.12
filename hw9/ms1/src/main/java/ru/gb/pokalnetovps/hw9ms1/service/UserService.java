package ru.gb.pokalnetovps.hw9ms1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw9ms1.model.User;
import ru.gb.pokalnetovps.hw9ms1.repository.IUserInterface;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {
    @Autowired
    IUserInterface repo;

    public void addUser(User user) {
        repo.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repo.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUserById(long id) {
        repo.deleteById(id);
    }
}
