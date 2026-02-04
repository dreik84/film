DELETE
FROM FILMS;
TRUNCATE TABLE USERS;

INSERT INTO films (NAME, DESCRIPTION, GENRE, RATE_MPA, RELEASE_DATE, DURATION)
VALUES ('Kill bill', 'description', 'action', '18+', '1995-04-24', 120),
       ('Bugs bunny', 'description', 'cartoon', '6+', '1997-06-14', 90),
       ('The boys', 'description', 'serial', '18+', '2019-03-22', 60);

INSERT INTO users (EMAIL, LOGIN, NAME, BIRTHDAY, FRIEND_STATE)
VALUES ('first@gmail.com', 'first', 'first user', '1984-09-12', 'state1'),
       ('second@mail.ru', 'second', 'second user', '1983-06-23', 'state2'),
       ('third@gmail.com', 'third', 'third user', '1985-04-13', 'state3');