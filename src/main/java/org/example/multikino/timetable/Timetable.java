package org.example.multikino.timetable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.multikino.films.Film;
import org.example.multikino.rooms.Room;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "timetable")
public class Timetable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "film_time")
  private Instant date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "filmId")
  private Film film;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "roomId")
  private Room room;
}
