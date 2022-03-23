package lk.quadrate.property.exceptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(OwnerPropertyNotFoundException.class)
    public ResponseEntity<Object> handleOwnerPropertyNotFoundException(OwnerPropertyNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse response = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(response,status);
    }

    @ExceptionHandler(PropertyTypeNotFoundException.class)
    public ResponseEntity<Object> handlePropertyTypeNotFoundException(PropertyTypeNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse response = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(status)
                .createdAt(LocalDateTime.now()).build();
        return new ResponseEntity<>(response,status);
    }


}
