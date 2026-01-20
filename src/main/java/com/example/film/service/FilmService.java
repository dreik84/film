package com.example.film.service;

import com.example.film.model.Film;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FilmService {
    private final Set<Long> films;

    public FilmService() {
        films = new HashSet<>();
    }

    public Film addLike(Film film) {
        films.add(film.getId());
        return film;
    }

    public Film removeLike(Film film) {
        films.remove(film.getId());
        return film;
    }

    public Set<Long> getTopTen() {
        return films;
    }
}
