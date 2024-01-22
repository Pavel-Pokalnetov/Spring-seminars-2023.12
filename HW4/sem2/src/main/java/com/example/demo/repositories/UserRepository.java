package com.example.demo.repositories;

import com.example.demo.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    /**
     * Конфигуратор SQL-запросов
     */
    private final SqlCMD sqlQuery;


    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc, SqlCMD sqlQuery) {
        this.jdbc = jdbc;
        this.sqlQuery = sqlQuery;
//        System.out.println(sqlQuery);
    }

    /**
     * Получение списка пользователей из базы данных
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sqlQuery.getFindAll(), userRowMapper);
    }

    /**
     * Запись пользоветля в базу
     *
     * @param user
     * @return
     */
    public User save(User user) {

        jdbc.update(sqlQuery.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользоветля по id
     *
     * @param id
     */
    public void deleteById(int id) {
        jdbc.update(sqlQuery.getDelete(), id);
    }

    /**
     * Получить user из базы по id
     *
     * @param id
     * @return - возвращает null если нет записей в базе
     */
    public User getById(int id) {
        if (!isExistUserById(id)) return null;//если нет записи с таким id - то отдаем null
        return jdbc.queryForObject(sqlQuery.getGetById(), (resultSet, rowNum) -> {
            User newUser = new User();
            newUser.setId(Integer.parseInt(resultSet.getString("id")));
            newUser.setFirstName(resultSet.getString("firstName"));
            newUser.setLastName(resultSet.getString("lastName"));
            return newUser;
        }, id);
    }

    /**
     * Обновить пользователя user, ключ - id
     *
     * @param user
     */
    public void updateUser(User user) {
        if (isExistUserById(user.getId())) { //если есть user с таким же id,  то обновляем
            jdbc.update(sqlQuery.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
        }
    }


    /**
     * Проверка существования записи
     *
     * @param id
     * @return true если есть запись с указанным id
     */
    private boolean isExistUserById(int id) {
        int countRow = jdbc.queryForObject(sqlQuery.getCount(), Integer.class, id);
        return countRow > 0;
    }
}
