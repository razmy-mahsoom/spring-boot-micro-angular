package lk.quadrate.owner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OwnerExistException extends RuntimeException{
    public OwnerExistException(String message) {
        super(message);
    }
}
