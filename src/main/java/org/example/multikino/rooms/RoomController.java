package org.example.multikino.rooms;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")

public class RoomController {
  private final RoomService roomService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<RoomResponse> getAllRooms (){
    return roomService.findAllRooms();
  }

  @GetMapping("/{number}")
  @ResponseStatus(HttpStatus.OK)
  public RoomResponse getRoomByNumber(@PathVariable int number){
   return roomService.findRoomById(number);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RoomResponse addRoom(@RequestBody @Valid RoomRequest roomRequest) {
    return roomService.addRoom(roomRequest);
  }


}
