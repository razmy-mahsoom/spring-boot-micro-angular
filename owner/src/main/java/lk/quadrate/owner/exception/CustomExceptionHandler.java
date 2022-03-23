package lk.quadrate.owner.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(OwnerExistException.class)
    public ResponseEntity<ExceptionResponse> handleOwnerExistException(OwnerExistException e){
        HttpStatus status = HttpStatus.CONFLICT;
        ExceptionResponse exception = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(exception, status);
    }

    @ExceptionHandler(OwnerNotFountException.class)
    public ResponseEntity<Object> handleOwnerNotFoundException(OwnerNotFountException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse exception = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(exception, status);
    }
}
