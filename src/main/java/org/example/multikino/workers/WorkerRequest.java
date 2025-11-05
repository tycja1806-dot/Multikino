package org.example.multikino.workers;

import jakarta.validation.constraints.NotBlank;

public record WorkerRequest(@NotBlank String name, @NotBlank String role) {
}
