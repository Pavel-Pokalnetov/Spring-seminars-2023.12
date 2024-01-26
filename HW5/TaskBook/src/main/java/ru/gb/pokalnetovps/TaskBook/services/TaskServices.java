package ru.gb.pokalnetovps.TaskBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.model.TaskStatus;
import ru.gb.pokalnetovps.TaskBook.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServices {

    @Autowired
    TaskRepository taskRep;

    public List<Task> getAllTask(){
        return StreamSupport.stream(taskRep.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public void saveTask(Task task){
        taskRep.save(task);
    }

    public Task addTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setCreatedDate(LocalDateTime.now());
        return task;
    }

    public void delTask(Long id) {
        if(taskRep.existsById(id))
            taskRep.deleteById(id);
    }
}
