package com.example.film.storage;

import com.example.film.model.User;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

@Qualifier
public class UserDbStorage implements UserStorage {

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
    public User getUserById(Long id) {
        return null;
    }
}
