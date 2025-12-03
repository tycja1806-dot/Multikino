package org.example.multikino.films;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmService {
  private final FilmRepository filmRepository;

  public static FilmResponse getFilmResponse(Film film) {
    return new FilmResponse(film.getID(), film.getTitle());
  }

  public List<FilmResponse> findAllFilms() {
    return filmRepository.findAll().stream().map(FilmService::getFilmResponse).toList();
  }

  public FilmResponse findFilmById(Long id) {
    return filmRepository.findById(id).map(FilmService::getFilmResponse).orElse(null);
  }

  public FilmResponse addFilm(@Valid FilmRequest filmRequest) {
    Film film = new Film();
    film.setTitle(film.getTitle());
    film = filmRepository.save(film);
    return getFilmResponse(film);
  }

  public void deleteFilmById(Long id) {
    if (!filmRepository.existsById(id)) {
      throw new IllegalArgumentException("Film nie istnieje");
    }
    filmRepository.deleteById(id);
  }
}
