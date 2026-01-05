package com.example.film.controller;

import com.example.film.model.Film;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FilmController {
    private final Map<Long, Film> films = new HashMap();

    @PostMapping("/films")
    public Film addFilm(@RequestBody Film film) {
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
