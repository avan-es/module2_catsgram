package ru.yandex.practicum.catsgram.DAO.impl;

import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.catsgram.DAO.UserDao;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Optional;

@Component
@Log
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUserById(String id) {
        // выполняем запрос к базе данных
        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = ?", id);
        if (userRows.next()) {
            // вы заполните данные пользователя в следующем уроке
            User user = new User(
                    userRows.getString("id"),
                    userRows.getString("username"),
                    userRows.getString("nickname")
            );
            log.info("Найден пользователь: " + userRows.getString("id") + " " + userRows.getString("nickname"));
            return Optional.of(user);
        } else {
            log.info("Пользователь с идентификатором "+ id +" не найден.");
            return Optional.empty();
        }
    }
}
