package com.example.film.controller;

import com.example.film.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final Map<Long, User> users = new HashMap();

    @PostMapping("/users")
    public User addFilm(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }

    @PutMapping("/users")
    public User updateFilm(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/users")
    public Map<Long, User> getFilms() {
        return users;
    }
}
