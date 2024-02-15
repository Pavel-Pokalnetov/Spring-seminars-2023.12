package ru.gb.pokalnetovps.hw11.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pokalnetovps.hw11.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);
}
