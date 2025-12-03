package org.example.multikino.timetable;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/timetable")

public class TimetableController {
  private final TimetableService timetableService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TimetableResponse> findAll() {
    return timetableService.findAllTimetables();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public TimetableResponse findById(@PathVariable Long id) {
    return timetableService.findById(id);
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TimetableResponse addTimetable(@RequestBody @Valid TimetableRequest timetable) {
    return timetableService.addTimetable(timetable);
  }
}
