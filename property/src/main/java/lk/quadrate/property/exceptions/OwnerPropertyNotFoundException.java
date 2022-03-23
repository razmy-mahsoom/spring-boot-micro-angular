package lk.quadrate.property.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerPropertyNotFoundException extends RuntimeException {
    public OwnerPropertyNotFoundException(String message) {
        super(message);
    }
}
