package ru.gb.pokalnetovps.hw7.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.pokalnetovps.hw7.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String userName);
}
