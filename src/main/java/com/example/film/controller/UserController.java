package com.example.film.controller;

import com.example.film.exception.ValidationException;
import com.example.film.model.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final Map<Long, User> users = new HashMap<>();

    @PostMapping("/users")
    public User addFilm(@RequestBody User user) {
        if (user.getEmail().isBlank() || !user.getEmail().contains("@"))
            throw new ValidationException("Электронная почта не должна быть пустой");
        if (user.getLogin().isBlank())
            throw new ValidationException("Логин не может быть пустым");
        if (user.getName().isBlank())
            user.setName(user.getLogin());
        if (user.getBirthday().isAfter(LocalDate.now()))
            throw new ValidationException("Дата рождения не может быть в будующем");

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

    @ExceptionHandler(ValidationException.class)
    public Map<String, String> handle(final ValidationException e) {
        return Map.of(
                e.getClass().toGenericString(), e.getMessage()
        );
    }
}
