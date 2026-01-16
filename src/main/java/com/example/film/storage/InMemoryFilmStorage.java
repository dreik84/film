package com.example.film.storage;

import com.example.film.model.Film;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InMemoryFilmStorage implements FilmStorage {

    @Override
    public Film addFilm(Film film) {
        return null;
    }

    @Override
    public Film updateFilm(Film film) {
        return null;
    }

    @Override
    public Map<Long, Film> getFilms() {
        return Map.of();
    }
}
