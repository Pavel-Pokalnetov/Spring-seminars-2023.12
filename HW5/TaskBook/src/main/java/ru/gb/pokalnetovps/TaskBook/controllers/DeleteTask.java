package ru.gb.pokalnetovps.TaskBook.controllers;

import ch.qos.logback.core.model.Model;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

@Controller
@Log
public class DeleteTask {
    @Autowired
    TaskServices ts;


    @GetMapping("/deltask/{id}")
    public ModelAndView delTask(@PathVariable Long id){
     ts.delTask(id);
        return new ModelAndView("redirect:/");
    }
}
