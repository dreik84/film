package com.example.film.storage;

import com.example.film.model.Film;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryFilmStorage implements FilmStorage {
    private final Map<Long, Film> films = new HashMap<>();

    @Override
    public Film addFilm(Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        films.put(film.getId(), film);
        return null;
    }

    @Override
    public Map<Long, Film> getFilms() {
        return films;
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return Optional.of(films.get(id));
    }

    @Override
    public Film deleteFilm(Long id) {
        return null;
    }
}
