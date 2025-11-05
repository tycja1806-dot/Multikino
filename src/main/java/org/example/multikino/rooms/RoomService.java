package org.example.multikino.rooms;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
  private final RoomRepository roomRepository;

  public List<RoomResponse> findAllRooms() {
    return roomRepository.findAll().stream().map(this::mapToRoomResponse).toList();
  }

  public RoomResponse findRoomById(int number) {
    Room room = roomRepository.findByNumber(number).orElseThrow(() -> new EntityNotFoundException("Brak tego pokoju"));
    return mapToRoomResponse(room);
  }

  private RoomResponse mapToRoomResponse(Room room) {
    return new RoomResponse(room.getNumber(), room.getCapacity());
  }

  public RoomResponse addRoom(@Valid RoomRequest roomRequest) {
    Room r1 = new Room();
    int number = roomRequest.number();
    if (roomRepository.findById(number).isPresent()) {
      throw new IllegalArgumentException("Numer pokoju jest już zajęty!");
    }
    r1.setNumber(number);
    r1.setCapacity(roomRequest.capacity());
    r1 = roomRepository.save(r1);
    return mapToRoomResponse(r1);
  }


}
