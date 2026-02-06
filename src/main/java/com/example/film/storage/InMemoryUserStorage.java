package com.example.film.storage;

import com.example.film.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User addUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Map<Long, User> getUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.of(users.get(id));
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
