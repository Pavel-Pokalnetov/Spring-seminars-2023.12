package ru.gb.hw3.seminar3.controllers.RestAPI;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.hw3.seminar3.domain.User;
import ru.gb.hw3.seminar3.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/task/sort")
    public List<User> sortUsersByAge(){
        return service.sortUsersByAge(service.getUsersRepository().getUsers());
    }

    @GetMapping("/task/filter/{age}")
    public List<User> filterUsersByAge(@RequestParam int age){
        return service.filterUsersByAge(service.getUsersRepository().getUsers(),age);
    }
}
