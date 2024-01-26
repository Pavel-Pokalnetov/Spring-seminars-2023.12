package ru.gb.pokalnetovps.TaskBook.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.pokalnetovps.TaskBook.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
