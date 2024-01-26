package ru.gb.pokalnetovps.TaskBook.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
List<Task> findByStatus(TaskStatus taskStatus);
}
