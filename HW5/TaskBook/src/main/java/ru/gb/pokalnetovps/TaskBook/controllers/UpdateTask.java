package ru.gb.pokalnetovps.TaskBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

@Controller
public class UpdateTask {

    @Autowired
    TaskServices ts;
    @GetMapping("/upd/{id}")
    public String updateTask(@PathVariable Long id){
        ts.updateStatus(id);
        return "redirect:/";
    }
}
