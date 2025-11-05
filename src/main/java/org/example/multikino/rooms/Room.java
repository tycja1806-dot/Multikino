package org.example.multikino.rooms;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
  @Id
  private Integer number;
  @Column(nullable = false)
  private Integer capacity;
}
