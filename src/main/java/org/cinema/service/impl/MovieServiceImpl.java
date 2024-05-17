package org.cinema.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.cinema.exception.GenreNotFoundException;
import org.cinema.exception.MovieNotFoundException;
import org.cinema.model.Genre;
import org.cinema.model.Movie;
import org.cinema.model.Rating;
import org.cinema.repository.GeneralRepo;
import org.cinema.service.MovieService;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    @Inject
    private GeneralRepo repo;

    @Override
    public List<Movie> getAllMovies(){
        return repo.getMovies();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) throws GenreNotFoundException {
        if (Arrays.stream(Genre.values()).noneMatch(g -> g.name().equals(genre))) {
            throw new GenreNotFoundException("Genre doesn't exist");
        }
        return repo.getMovies().stream()
                .filter(m -> m.getGenres().contains(Genre.valueOf(genre)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesByRating(Rating rating) {
        return repo.getMovies().stream()
                .filter(m -> m.getRating().equals(rating))
                .collect(Collectors.toList());
    }

    @Override
    public Movie getMovieByTitle(String title) throws MovieNotFoundException {
        Optional<Movie> movie = repo.getMovies().stream()
                .filter(m -> m.getTitle().equals(title))
                .findAny();
        if (movie.isEmpty())
            throw new MovieNotFoundException(String.format("Movie with title %s doesn't exist", title));

        return movie.get();
    }

    @Override
    public List<Movie> getMoviesByActorName(String firstName, String lastName) {
        return repo.getMovies().stream()
                .filter(m -> m.getActors().stream().anyMatch(actor ->
                        actor.getFirstName().equals(firstName)
                                && actor.getLastName().equals(lastName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesByReleaseYear(Year year) {
        return repo.getMovies().stream()
                .filter(movie -> movie.getReleaseDate().getDayOfYear() == year.getValue())
                .collect(Collectors.toList());
    }
}
