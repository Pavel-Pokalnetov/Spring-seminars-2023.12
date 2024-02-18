package ru.gb.pokalnetovps.hw12.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pokalnetovps.hw12.model.User;

@Repository
public interface IUserInterface extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);
}
