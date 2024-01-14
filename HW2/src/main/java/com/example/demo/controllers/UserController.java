package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        User startUser = new User();
        startUser.setId(1);
        startUser.setFirstName("Jhon");
        startUser.setLastName("Connor");
        userService.saveUser(startUser);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String editUser(Model model, @PathVariable int id){
        System.out.println("ID="+id);
        User user = userService.getUserByID(id);
        System.out.println("User="+user);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/user-update/{id}")
    public String updateUser(User user){
        System.out.println("form Controller: User="+user);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
