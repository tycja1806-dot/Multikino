package org.example.multikino.workers;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // zaznacza , ze ta klasa reprezentuje wiersz bazy danych
@Data // dodaje gettery, settery, equals, hashcode, required args constructor
@NoArgsConstructor  // konstruktor bezargumentowy
@Table (name = "workers") // nazwa tabeli
public class Worker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String role;


}
