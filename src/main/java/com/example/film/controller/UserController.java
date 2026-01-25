package com.example.film.controller;

import com.example.film.exception.ValidationException;
import com.example.film.model.User;
import com.example.film.service.UserService;
import com.example.film.storage.UserStorage;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class UserController {
    private final UserStorage storage;
    private final UserService service;

    @Autowired
    public UserController(UserStorage storage, UserService service) {
        this.storage = storage;
        this.service = service;
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        if (user.getEmail().isBlank() || !user.getEmail().contains("@"))
            throw new ValidationException("Электронная почта не должна быть пустой");
        if (user.getLogin().isBlank())
            throw new ValidationException("Логин не может быть пустым");
        if (user.getName().isBlank())
            user.setName(user.getLogin());
        if (user.getBirthday().isAfter(LocalDate.now()))
            throw new ValidationException("Дата рождения не может быть в будующем");

        storage.addUser(user);
        log.info("Добавлен новый пользователь с id {}", user.getId());
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User user) {
        storage.addUser(user);
        log.info("Обновлен пользователь с id {}", user.getId());
        return user;
    }

    @PutMapping("/users/{id}/friends/{friendId}")
    public User addToFriends(@PathVariable Long id, @PathVariable Long friendId) {
        User friend = storage.getUserById(friendId);
        service.addToFriends(friend);
        return friend;
    }

    @DeleteMapping("/users/{id}/friends/{friendId}")
    public User deleteFromFriends(@PathVariable Long id, @PathVariable Long friendId) {
        User friend = storage.getUserById(friendId);
        service.deleteFromFriends(friend);
        return friend;
    }

    @GetMapping("/users")
    public Map<Long, User> getUsers() {
        return storage.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        if (id == null) {
            throw new ValidationException("Параметр id равен null.");
        }
        return storage.getUserById(id);
    }

    @GetMapping("/users/{id}/friends/common/{otherId}")
    public Set<Long> getCommonFriends(@PathVariable Long id, @PathVariable Long otherId) {
        User other = storage.getUserById(otherId);
        return service.getCommonFriends(other);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(final ValidationException e) {
        log.error(e.getMessage());

        return Map.of(
                e.getClass().toGenericString(), e.getMessage()
        );
    }
}
