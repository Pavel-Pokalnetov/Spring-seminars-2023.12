package ru.gb.pokalnetovps.TaskBook.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    /** получить список задач по их статусу
     * @param taskStatus
     * @return
     */
List<Task> findByStatus(TaskStatus taskStatus);
}
