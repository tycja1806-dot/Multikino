package org.example.multikino;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExeptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleChangeBookException(IllegalArgumentException ex) {
    return new ExceptionResponse(ex.getMessage());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleChangeBookException(EntityNotFoundException ex) {
    return new ExceptionResponse(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleChangeBookException(MethodArgumentNotValidException ex) {
    List<String> errors = new ArrayList<>();

    ex.getBindingResult().getFieldErrors()
        .forEach((fieldError) -> errors.add(fieldError.getDefaultMessage()));

    return new ExceptionResponse(errors.toString());
  }
}
