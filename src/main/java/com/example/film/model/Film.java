package com.example.film.model;

import lombok.Data;

@Data
public class Film {
    private long id;
    private String name;
    private String description;
    private String releaseDate;
    private int duration;
}
