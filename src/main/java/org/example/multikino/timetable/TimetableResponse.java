package org.example.multikino.timetable;

import org.example.multikino.films.FilmResponse;
import org.example.multikino.rooms.RoomResponse;

import java.time.Instant;

public record TimetableResponse(Long id, Instant date, FilmResponse film, RoomResponse room) {
}
