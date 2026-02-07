package com.example.film.service;

import com.example.film.model.Film;
import com.example.film.storage.FilmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FilmService {
    private final Set<Long> films;
    private final FilmStorage storage;

    @Autowired
    public FilmService(@Qualifier("") FilmStorage storage) {
        this.storage = storage;
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
