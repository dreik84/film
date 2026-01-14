package com.example.film.controller;

import com.example.film.exception.ValidationException;
import com.example.film.model.Film;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FilmController {
    private final Map<Long, Film> films = new HashMap<>();
    private final static Logger log = LoggerFactory.getLogger(FilmController.class);

    @PostMapping("/films")
    public Film addFilm(@Valid @RequestBody Film film) {
        if (film.getName().isBlank())
            throw new ValidationException("Название фильма не может быть пустым");
        if (film.getDescription().length() > 200)
            throw new ValidationException("Максимальная длина описания - 200 симыолов");
        if (LocalDate.of(1895, 12, 28).isBefore(film.getReleaseDate()))
            throw new ValidationException("Дата релиза должна быть не раньше 28 декабря 1895 года");
        if (film.getDuration().toMillis() <= 0)
            throw new ValidationException("Продолжительность фильма должна быть положительной");

        films.put(film.getId(), film);
        log.info("Добавлен новый фильм с id {}", film.getId());
        return film;
    }

    @PutMapping("/films")
    public Film updateFilm(@Valid @RequestBody Film film) {
        films.put(film.getId(), film);
        log.info("Обновлен фильм с id {}", film.getId());
        return film;
    }

    @GetMapping("/films")
    public Map<Long, Film> getFilms() {
        return films;
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
