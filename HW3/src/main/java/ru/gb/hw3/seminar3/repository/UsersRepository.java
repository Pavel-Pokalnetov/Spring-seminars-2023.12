package ru.gb.hw3.seminar3.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.gb.hw3.seminar3.domain.User;

import java.util.List;


@Setter
@Getter
@Component
public class UsersRepository {
    private List<User> users;

    public UsersRepository() {
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
