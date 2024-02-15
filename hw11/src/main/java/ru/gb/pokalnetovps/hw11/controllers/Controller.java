package ru.gb.pokalnetovps.hw11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.pokalnetovps.hw11.model.User;
import ru.gb.pokalnetovps.hw11.service.UserService;

import java.util.List;

/* Контроллер работы с пользователями
 * GET /users - получить все логины пользователей
 * GET /users/{id} - получить пользователя с указанным id
 * POST /users - добавить пользователя ( в запросе должен быть пердан JSON{name,login,password})
 * DELETE /users/{id} - удалить пользователя с указанным id
 */
@RestController
public class Controller {
    @Autowired
    UserService us;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = us.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = us.getUserById(id);
        System.out.println(user);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User createdUser = us.addUser(user);
        if (createdUser == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delUserById(@PathVariable long id) {
        us.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
