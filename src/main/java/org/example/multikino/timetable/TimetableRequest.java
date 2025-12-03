package org.example.multikino.timetable;

import jakarta.validation.constraints.Min;

import java.time.Instant;

public record TimetableRequest(Instant date, @Min(1) Long filmID, @Min(1) Integer roomID) {
}
