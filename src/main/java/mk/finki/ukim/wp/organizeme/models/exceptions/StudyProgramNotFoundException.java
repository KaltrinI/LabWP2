package mk.finki.ukim.wp.organizeme.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such study program")
public class StudyProgramNotFoundException extends Exception {
    public StudyProgramNotFoundException(String message) {
        super(message);
    }
}
