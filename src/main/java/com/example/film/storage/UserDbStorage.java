package com.example.film.storage;

import com.example.film.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Qualifier
@Component
public class UserDbStorage implements UserStorage {
    private final Logger log = LoggerFactory.getLogger(UserDbStorage.class);

    private final JdbcTemplate jdbcTemplate;

    public UserDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User user) {


        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public Map<Long, User> getUsers() {
        SqlRowSet usersRow = jdbcTemplate.queryForRowSet("SELECT * FROM users");
        Map<Long, User> users = new HashMap<>();

        while (usersRow.next()) {
            User user = new User();
            user.setId(usersRow.getLong("id"));
            user.setEmail(usersRow.getString("email"));
            user.setLogin(usersRow.getString("login"));
            user.setBirthday(usersRow.getDate("birthday").toLocalDate());
            user.setFriendState(usersRow.getString("friend_state"));
        }

        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        SqlRowSet userRow = jdbcTemplate.queryForRowSet("SELECT * FROM users WHERE id = ?", id);

        if (userRow.next()) {
            log.info("Найден пользователь: {} {}", userRow.getLong("id"), userRow.getString("name"));

            User user = new User();
            user.setId(id);
            user.setEmail(userRow.getString("email"));
            user.setLogin(userRow.getString("login"));
            user.setBirthday(userRow.getDate("birthday").toLocalDate());
            user.setFriendState(userRow.getString("friend_state"));

            return Optional.of(user);
        }

        return Optional.empty();
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
