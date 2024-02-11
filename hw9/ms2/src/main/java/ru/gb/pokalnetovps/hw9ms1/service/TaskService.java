package ru.gb.pokalnetovps.hw9ms1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw9ms1.model.Task;
import ru.gb.pokalnetovps.hw9ms1.repository.ITaskInterface;

import java.util.ArrayList;
import java.util.List;

@Service

public class TaskService {
    @Autowired
    ITaskInterface repo;

    public void addTask(Task task) {
        repo.save(task);
    }

    public List<Task> getAllTasks() {
        List<Task> Tasks = new ArrayList<>();
        repo.findAll().forEach(Tasks::add);
        return Tasks;
    }

    public Task getTaskById(long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteTaskById(long id) {
        repo.deleteById(id);
    }
}
