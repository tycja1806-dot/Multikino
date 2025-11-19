package org.example.multikino.films;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/films")

public class FilmController {
  private final FilmService filmService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FilmResponse addFilm(@RequestBody @Valid FilmRequest filmRequest) {
    return filmService.addFilm(filmRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FilmResponse> findAllFilms() {
    return filmService.findAllFilms();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FilmResponse findFilmById(@PathVariable("id") Long id) {
    return filmService.findFilmById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteFilmById(@PathVariable("id") Long id) {
    filmService.deleteFilmById(id);

  }


}
