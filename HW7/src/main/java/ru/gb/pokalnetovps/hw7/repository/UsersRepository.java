package ru.gb.pokalnetovps.hw7.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.pokalnetovps.hw7.model.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByName(String userName);
}
