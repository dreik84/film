package com.example.film.controller;

import com.example.film.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FilmController {
    private final Map<Long, Film> films = new HashMap();

    @PostMapping("/films")
    public Film addFilm(Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @PutMapping("/films")
    public Film updateFilm(Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @GetMapping("/films")
    public Map<Long, Film> getFilms() {
        return films;
    }
}
