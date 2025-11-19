package org.example.multikino.films;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record FilmRequest
    (@NotBlank String title) {
}

