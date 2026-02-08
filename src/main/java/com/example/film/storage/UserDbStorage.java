package com.example.film.storage;

import com.example.film.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Qualifier
@Component
public class UserDbStorage implements UserStorage {
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
        return Map.of();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        SqlRowSet userRow = jdbcTemplate.queryForRowSet("SELECT * users WHERE id = ?;");
        User user = new User();
        user.setId(id);

        return Optional.of(user);
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
