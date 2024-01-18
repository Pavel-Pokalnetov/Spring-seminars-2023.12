package ru.gb.hw3.seminar3.services;

import org.springframework.stereotype.Service;
import ru.gb.hw3.seminar3.domain.User;
@Service
public class NotificationService {

    public void notifyUser(User user){
        System.out.println("A new user has been created: "+user.getName());
    }
}
