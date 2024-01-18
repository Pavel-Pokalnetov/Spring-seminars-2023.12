package ru.gb.hw3.seminar3.controllers.WebAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/")
    public String getCreateUserForm(){
        System.out.println("visit to root server dir");
        return "redirect:/create-user.html";
    }
}
