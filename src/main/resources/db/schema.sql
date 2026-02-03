DROP TABLE IF EXISTS films;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS films
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(256) NOT NULL,
    description  VARCHAR(256),
    genre        VARCHAR(256),
    rate_mpa     VARCHAR(256),
    release_date DATE,
    duration     INT
    );

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(256) UNIQUE,
    login VARCHAR(256) NOT NULL,
    name VARCHAR(256),
    birthday DATE,
    friend_state VARCHAR(256)
    );