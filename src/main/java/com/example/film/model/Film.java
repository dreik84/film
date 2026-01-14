package com.example.film.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class Film {
    private long id;

    @NotBlank
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Duration duration;
}
