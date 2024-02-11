package ru.gb.pokalnetovps.hw9ms1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pokalnetovps.hw9ms1.model.User;

@Repository
public interface IUserInterface extends CrudRepository<User, Long> {

}
