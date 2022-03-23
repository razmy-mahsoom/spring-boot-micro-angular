package lk.quadrate.property.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PropertyTypeNotFoundException extends RuntimeException {
    public PropertyTypeNotFoundException(String message) {
        super(message);
    }
}
