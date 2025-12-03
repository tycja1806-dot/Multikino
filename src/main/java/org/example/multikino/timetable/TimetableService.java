package org.example.multikino.timetable;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.multikino.films.Film;
import org.example.multikino.films.FilmRepository;
import org.example.multikino.films.FilmService;
import org.example.multikino.rooms.Room;
import org.example.multikino.rooms.RoomRepository;
import org.example.multikino.rooms.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {
  private final TimetableRepository timetableRepository;
  private final FilmRepository filmRepository;
  private final RoomRepository roomRepository;

  private static TimetableResponse getTimetableResponse(Timetable timetable) {
    return new TimetableResponse(timetable.getId(), timetable.getDate(), FilmService.getFilmResponse(timetable.getFilm()), RoomService.mapToRoomResponse(timetable.getRoom()));
  }

  public List<TimetableResponse> findAllTimetables() {
    return timetableRepository.findAll().stream().map(TimetableService::getTimetableResponse).toList();
  }

  public TimetableResponse findById(Long id) {
    Timetable timetable = timetableRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Timetable with id " + id + " not found"));
    return getTimetableResponse(timetable);
  }

  public TimetableResponse addTimetable(@Valid TimetableRequest timetable) {
    Timetable timetableNew = new Timetable();

    Film f1 = filmRepository.findById(timetable.filmID()).orElseThrow(() -> new EntityNotFoundException("Film with id " + timetable.filmID() + " not found"));

    Room r1 = roomRepository.findByNumber(timetable.roomID()).orElseThrow(() -> new EntityNotFoundException("Room with id " + timetable.roomID() + " not found"));
    timetableNew.setDate(timetable.date());
    timetableNew.setFilm(f1);
    timetableNew.setRoom(r1);
    boolean unique = timetableRepository.findAll().stream().noneMatch(t -> t.getDate().equals(timetable.date()) && t.getRoom().equals(r1));
    if (!unique) {
      throw new IllegalArgumentException("Room " + r1.getNumber() + " is already taken at " + timetableNew.getDate().toString());
    }
    timetableNew = timetableRepository.save(timetableNew);
    return getTimetableResponse(timetableNew);
  }
}