package ru.gb.pokalnetovps.TaskBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

@Controller
public class ViewTask {
    @Autowired
    TaskServices ts;
    @GetMapping("/")
    public String viewTaskGet(Model model){
        model.addAttribute("tasks",ts.getAllTask());
        return "index";
    }
}

