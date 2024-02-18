package ru.gb.pokalnetovps.hw11.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.gb.pokalnetovps.hw11.service.FileLoggerGateway;

@Component
public class UserUpdateListener implements ApplicationListener<UserCreateEvent> {
    @Autowired
    FileLoggerGateway fileLoggerGateway;
    @Override
    public void onApplicationEvent(UserCreateEvent event) {
        fileLoggerGateway.writeToFile("addUsers_log.txt", event.getUser());
        System.out.println("Добавлен пользователь: " + event.getUser().toString());
    }
}
