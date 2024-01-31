package ru.gb.pokalnetovps.hw7.repository;


import org.springframework.data.repository.ListCrudRepository;
import ru.gb.pokalnetovps.hw7.model.User;

public interface UsersRepository extends ListCrudRepository<User,Long> {

}
