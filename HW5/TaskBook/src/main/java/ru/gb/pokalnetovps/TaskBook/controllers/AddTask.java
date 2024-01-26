package ru.gb.pokalnetovps.TaskBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.repository.TaskRepository;
import org.springframework.ui.Model;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

@Controller
public class AddTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/addtask")
    public String addTaskForm(){
        return "addtask";
    }

    @PostMapping("/addtask")
    public String addTaskAction(
            @RequestParam String name,
            @RequestParam String description,
            Model model){
        ts.saveTask(ts.addTask(name,description));
        model.addAttribute("tasks",ts.getAllTask());
        return "index";
    }
}
