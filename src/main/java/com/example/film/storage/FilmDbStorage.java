package com.example.film.storage;

import com.example.film.model.Film;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.Optional;

@Qualifier
public class FilmDbStorage implements FilmStorage {

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

    @Override
    public Optional<Film> getFilmById(Long id) {
        return null;
    }

    @Override
    public Film deleteFilm(Long id) {
        return null;
    }
}
