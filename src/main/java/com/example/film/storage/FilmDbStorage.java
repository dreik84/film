package com.example.film.storage;

import com.example.film.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Qualifier
@Component
public class FilmDbStorage implements FilmStorage {
    private final Logger log = LoggerFactory.getLogger(FilmDbStorage.class);

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
        SqlRowSet filmsRow = jdbcTemplate.queryForRowSet("SELECT * FROM FILMS");
        Map<Long, Film> films = new HashMap<>();

        while (filmsRow.next()) {
            Film film = new Film();
            film.setId(filmsRow.getLong("id"));
            film.setDescription(filmsRow.getString("description"));
            film.setGenre(filmsRow.getString("genre"));
            film.setRateMPA(filmsRow.getString("rate_mpa"));
            film.setReleaseDate(filmsRow.getDate("release_date").toLocalDate());
            film.setDuration(Duration.ofDays(filmsRow.getInt("duration")));

            films.put(film.getId(), film);
        }

        return films;
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        SqlRowSet filmRow = jdbcTemplate.queryForRowSet("SELECT * films WHERE id = ?", id);
        if (filmRow.next()) {
            log.info("Найден фильм: {} {}", filmRow.getLong("id"), filmRow.getString("name"));

            Film film = new Film();
            film.setId(id);
            film.setDescription(filmRow.getString("description"));
            film.setGenre(filmRow.getString("genre"));
            film.setRateMPA(filmRow.getString("rate_mpa"));
            film.setReleaseDate(filmRow.getDate("release_date").toLocalDate());
            film.setDuration(Duration.ofDays(filmRow.getInt("duration")));

            return Optional.of(film);
        }

        return Optional.empty();
    }

    @Override
    public Film deleteFilm(Long id) {
        return null;
    }
}
