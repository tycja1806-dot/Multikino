package org.example.multikino.workers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // zaznacza , ze ta klasa reprezentuje wiersz bazy danych
@Data // dodaje gettery, settery, equals, hashcode, required args constructor
@NoArgsConstructor  // konstruktor bezargumentowy
@Table (name = "workers") // nazwa tabeli
public class Worker {
  @Id
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String role;


}
