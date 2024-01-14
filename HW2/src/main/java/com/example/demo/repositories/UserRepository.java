package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
        return false;
    }

    public User getById(int id) {
        String sql = "SELECT id,firstName,lastName FROM userTable WHERE id = ?";

        User user = jdbc.queryForObject(sql,
                (resultSet, rowNum) -> {
                    User newUser = new User();
                    newUser.setId(Integer.parseInt(resultSet.getString("id")));
                    newUser.setFirstName(resultSet.getString("firstName"));
                    newUser.setLastName(resultSet.getString("lastName"));
                    return newUser;
                },id);
        System.out.println("in getByID: user="+user);
        return user;
    }

    public void updateUser(User user) {
        String sql = "update userTable set firstNane = ?, lastName = ? where id = ?";
        jdbc.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getId());
    }
}
