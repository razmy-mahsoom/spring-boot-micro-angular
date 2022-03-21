package lk.quadrate.owner.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@Builder
public class ExceptionResponse {

    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime createdAt;
}
