package com.example.film.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private long id;

    @Email
    private String email;

    @NotNull
    private String login;
    private String name;
    private LocalDate birthday;
}
