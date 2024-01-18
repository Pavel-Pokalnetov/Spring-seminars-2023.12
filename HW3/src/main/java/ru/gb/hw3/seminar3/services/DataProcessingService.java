package ru.gb.hw3.seminar3.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.repository.UsersRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class DataProcessingService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> sortUsersByAge(List<User> users){
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users,int age){
        return users.stream()
                .filter(user->user.getAge()>age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
