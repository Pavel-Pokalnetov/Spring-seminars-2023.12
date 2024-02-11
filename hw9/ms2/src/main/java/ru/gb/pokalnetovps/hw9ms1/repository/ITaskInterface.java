package ru.gb.pokalnetovps.hw9ms1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pokalnetovps.hw9ms1.model.Task;

@Repository
public interface ITaskInterface extends CrudRepository<Task, Long> {

}
