package org.cinema.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.cinema.exception.GenreNotFoundException;
import org.cinema.model.Movie;
import org.cinema.model.Rating;
import org.cinema.util.MovieComparator;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ExternalService {
    @Inject
    private MovieService service;
    @Inject
    private MovieComparator comparator;

    public List<Movie> getMostRatedMoviesFromGenre(String genre) throws GenreNotFoundException {
        List<Movie> moviesByGenre = moviesByGenre = service.getMoviesByGenre(genre);
        return moviesByGenre.stream()
                .filter(movie -> movie.getRating().equals(Rating.FIVE_STARS))
                .toList();
    }

    public List<Movie> getSortedMoviesByReleaseDate() {
        List<Movie> movies = service.getAllMovies();
        movies.sort(comparator);
        return movies;
    }

    public void setService(MovieService service) {
        this.service = service;
    }
}
