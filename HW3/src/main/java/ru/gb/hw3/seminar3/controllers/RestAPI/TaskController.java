package ru.gb.hw3.seminar3.controllers.RestAPI;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController

public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping("/tasks")
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Список пользователей сортировка по возрасту
     *
     * @return
     */
    @GetMapping("/tasks/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getUsersRepository().getUsers());
    }

    /**
     * Фильтрованный список пользователей (если возрасть больше {age})
     *
     * @param age
     * @return
     */
    @GetMapping("/tasks/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getUsersRepository().getUsers(), age);
    }

    /**
     * Средний возрасть всех в виде json
     *
     * @return {"average":"XX.X"} - XX.X -возрасть с точностью 1 знако после запяой
     */
    @GetMapping("/tasks/calc")
    public String calcAverageAgeFromUsers() {
        double avrAge = service.calculateAverageAge(service.getUsersRepository().getUsers());
        return String.format("{\"average\":\"%.1f\"}", avrAge);
    }
}
