package ru.gb.hw3.seminar3.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.gb.hw3.seminar3.domain.User;

import java.util.List;


@Component
public class UsersRepository {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
