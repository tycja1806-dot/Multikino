CREATE TABLE rooms
(
    number   INT    NOT NULL,
    capacity INT    NOT NULL,
    PRIMARY KEY (number)
);
CREATE TABLE workers
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE films
(
    id    BIGINT  NOT NULL AUTO_INCREMENT,
    title VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE timetable
(
    id        BIGINT   NOT NULL AUTO_INCREMENT,
    film_time DATETIME NOT NULL,
    film_id   BIGINT   NOT NULL,
    room_id   INT   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES films (id),
    FOREIGN KEY (room_id) REFERENCES rooms (number)
)
