package lk.quadrate.owner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFountException extends RuntimeException{
    public OwnerNotFountException(String message) {
        super(message);
    }

}
