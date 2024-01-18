package ru.gb.hw3.seminar3.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.gb.hw3.seminar3.domain.User;

import java.util.ArrayList;
import java.util.List;



@Component
public class UsersRepository {
    private final JdbcTemplate jdbc;

    private List<User> users;

    public UsersRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
//    public UsersRepository() {
//        System.out.println("create a new UsersRepository");
//        this.users = new ArrayList<>();
//        this.addUser(new User("Вася", 10, "vasya@mail.ru"));
//        this.addUser(new User("Маша", 20, "maria@mail.ru"));
//        this.addUser(new User("Петя", 40, "petya@mail.ru"));
//        this.addUser(new User("Женя", 50, "zhane@mail.ru"));
//    }
    /**
     * Получение списка пользователей из базы данных
     *
     * @return
     */
    public List<User> getUsers() throws DataAccessException {
        String sql = "SELECT name,age,email FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }
    public boolean addUser(User user) {
        String sql = "INSERT INTO userTable (name,age,email) VALUES (?,?,?)";
        try{
        jdbc.update(sql, user.getName(), user.getAge(),user.getEmail());
        return true;
        }catch (DataAccessException e){
            return false;
        }
    }
}
