package mk.finki.ukim.wp.organizeme.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid student index format")
public class IndexFormatException extends Exception {
    public IndexFormatException(String message) {
        super(message);
    }
}
