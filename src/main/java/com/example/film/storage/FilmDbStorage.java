package com.example.film.storage;

import com.example.film.model.Film;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Qualifier
@Component
public class FilmDbStorage implements FilmStorage {
    private final JdbcTemplate jdbcTemplate;

    public FilmDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        return Optional.empty();
    }

    @Override
    public Film deleteFilm(Long id) {
        return null;
    }
}
