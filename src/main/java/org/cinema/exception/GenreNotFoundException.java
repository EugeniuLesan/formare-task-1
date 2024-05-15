package org.cinema.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreNotFoundException extends Exception {

    public GenreNotFoundException(String message) {
        super(message);
    }
}
