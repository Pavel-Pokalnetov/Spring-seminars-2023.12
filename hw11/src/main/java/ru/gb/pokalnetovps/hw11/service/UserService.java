package ru.gb.pokalnetovps.hw11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw11.model.User;
import ru.gb.pokalnetovps.hw11.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {
    @Autowired
    IUserRepository repo;
    @Autowired
    MetricService ms;

    public User addUser(User user) {
        if (repo.existsByLogin(user.getLogin())) return null;
        repo.save(user);
        ms.update();
        return user;
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
        ms.update();
    }

    public int getUsersCount() {
        return (int) repo.count();
    }
}
