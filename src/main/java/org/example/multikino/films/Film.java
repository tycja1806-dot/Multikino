package org.example.multikino.films;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


  @Entity
  @Data
  @NoArgsConstructor
  @Table(name = "films")
  public class Film {
    @Id
    private Long ID;
    @Column(nullable = false)
    private String title;

  }

