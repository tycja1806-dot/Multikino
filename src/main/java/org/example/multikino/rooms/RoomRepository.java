package org.example.multikino.rooms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
  Optional<Room> findByNumber(int number);
}
