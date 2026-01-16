package com.example.film.storage;

import com.example.film.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InMemoryUserStorage implements UserStorage {

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
}
