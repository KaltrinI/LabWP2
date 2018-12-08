package mk.finki.ukim.wp.organizeme.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such student")
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message){
        super(message);
    }
}
