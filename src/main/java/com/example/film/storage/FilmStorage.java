package com.example.film.storage;

import com.example.film.model.Film;

import java.util.Map;
import java.util.Optional;

public interface FilmStorage {
    Film addFilm(Film film);

    Film updateFilm(Film film);

    Map<Long, Film> getFilms();

    Optional<Film> getFilmById(Long id);

    Film deleteFilm(Long id);
}
