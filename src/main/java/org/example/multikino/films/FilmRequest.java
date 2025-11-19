package org.example.multikino.films;

import jakarta.validation.constraints.NotBlank;

public record FilmRequest
    (@NotBlank String title) {
}

