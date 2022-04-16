package lk.quadrate.owner.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(OwnerExistException.class)
    public ResponseEntity<ExceptionResponse> handleOwnerExistException(OwnerExistException e) {
        HttpStatus status = CONFLICT;
        ExceptionResponse exception = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(exception, status);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(OwnerNotFountException.class)
    public ResponseEntity<Object> handleOwnerNotFoundException(OwnerNotFountException e) {
        HttpStatus status = NOT_FOUND;
        ExceptionResponse exception = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(exception, status);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        HttpStatus status = BAD_REQUEST;
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .createdAt(LocalDateTime.now())
                .message(ex.getMessage())
                .httpStatus(status)
                .errorObject(errorMap)
                .build();
        ex.getBindingResult().getFieldErrors().stream()
                .forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return new ResponseEntity<>(exceptionResponse, status);
    }
}
