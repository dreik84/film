package com.example.film.storage;

import com.example.film.model.Film;

import java.util.Map;

public interface FilmStorage {
    Film addFilm(Film film);

    Film updateFilm(Film film);

    Map<Long, Film> getFilms();
}
