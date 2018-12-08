package mk.finki.ukim.wp.organizeme.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Missing required argument")
public class MissingArgumentException extends Exception {
    public MissingArgumentException(String message) {
        super(message);
    }
}
