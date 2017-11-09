package fr.emse.majeureinfo.springbootintro.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown to signal that a resource can't be found. Translated to a 404 HTTP status.
 *
 * @author A Crepet
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

}
