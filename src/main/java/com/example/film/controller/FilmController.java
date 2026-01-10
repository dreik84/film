package com.example.film.controller;

import com.example.film.exception.ValidationException;
import com.example.film.model.Film;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FilmController {
    private final Map<Long, Film> films = new HashMap<>();

    @PostMapping("/films")
    public Film addFilm(@RequestBody Film film) {
        if (film.getName().isBlank()) throw new ValidationException();
        if (film.getDescription().length() > 200) throw new ValidationException();
        if (LocalDate.of(1895, 12, 28).isBefore(film.getReleaseDate())) throw new ValidationException();
        if (film.getDuration().toMillis() <= 0) throw new ValidationException();

        films.put(film.getId(), film);
        return film;
    }

    @PutMapping("/films")
    public Film updateFilm(@RequestBody Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @GetMapping("/films")
    public Map<Long, Film> getFilms() {
        return films;
    }
}
