package ru.gb.pokalnetovps.hw9ms1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.pokalnetovps.hw9ms1.model.Task;
import ru.gb.pokalnetovps.hw9ms1.service.TaskService;

import java.util.List;
/* Контроллер работы с задачами
 * GET /tasks - получить все задачи
 * GET /tasks/{id} - получить задачу с указанным id
 * POST /tasks - добавить задачу ( в запросе должен быть пердан JSON{title,text,userId})
 * DELETE /tasks/{id} - удалить задачу с указанным id
 */
@RestController
public class Controller {
    @Autowired
    TaskService us;

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = us.getAllTasks();
        if (tasks == null || tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task task = us.getTaskById(id);
        if (task == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/tasks/add")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        us.addTask(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> delTaskById(@PathVariable long id) {
        us.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }
}
