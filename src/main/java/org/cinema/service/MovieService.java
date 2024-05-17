package org.cinema.service;

import org.cinema.exception.GenreNotFoundException;
import org.cinema.exception.MovieNotFoundException;
import org.cinema.model.Movie;
import org.cinema.model.Rating;

import java.time.Year;
import java.util.List;

public interface MovieService {
    List<Movie> getMoviesByGenre(String genre) throws GenreNotFoundException;
    List<Movie> getMoviesByRating(Rating rating);
    Movie getMovieByTitle(String title) throws MovieNotFoundException;
    List<Movie> getMoviesByActorName(String firstName, String lastName);
    List<Movie> getMoviesByReleaseYear(Year year);
    List<Movie> getAllMovies();
}
