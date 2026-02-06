package com.example.film.storage;

import com.example.film.model.User;

import java.util.Map;
import java.util.Optional;

public interface UserStorage {
    User addUser(User user);

    User updateUser(User user);

    Map<Long, User> getUsers();

    Optional<User> getUserById(Long id);

    User deleteUser(Long id);
}
