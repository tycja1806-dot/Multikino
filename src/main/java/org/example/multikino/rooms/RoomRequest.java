package org.example.multikino.rooms;

import jakarta.validation.constraints.Min;
import lombok.NonNull;

public record RoomRequest(@NonNull @Min(value = 1, message = "number musi byc wieksze niz 0") Integer number,
                          @NonNull @Min(value = 1, message = "capacity musi byc wieksze niz 0") Integer capacity) {
}
