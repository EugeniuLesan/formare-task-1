package org.cinema.exception;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String message) {
        super(message);
    }
}
