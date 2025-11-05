package org.example.multikino.rooms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record RoomRequest( @NonNull @Min(1) Integer number , @NonNull @Min(1) Integer capacity) {
}
