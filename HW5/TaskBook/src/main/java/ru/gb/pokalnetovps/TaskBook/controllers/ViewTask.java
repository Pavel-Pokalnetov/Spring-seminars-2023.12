package ru.gb.pokalnetovps.TaskBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.model.TaskStatus;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

import java.util.List;

@Controller
public class ViewTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/")
    public String viewTaskGet(@RequestParam(value = "filter", required = false) String filter,
                              Model model) {
        if (filter == null) filter = "all";
        List<Task> tasks = switch (filter) {
            case "all" -> ts.getAllTask();
            case "nostart" -> ts.getTaskByStatus(TaskStatus.NOT_STARTED);
            case "inwork" -> ts.getTaskByStatus(TaskStatus.IN_PROGRESS);
            case "ready" -> ts.getTaskByStatus(TaskStatus.COMPLETED);
            default -> ts.getAllTask();
        };
        model.addAttribute("tasks",tasks);
        model.addAttribute("filter",filter);
        return "index";
    }
}

