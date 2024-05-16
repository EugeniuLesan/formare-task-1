package org.cinema.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.cinema.exception.GenreNotFoundException;
import org.cinema.model.Genre;
import org.cinema.model.Movie;
import org.cinema.model.Rating;
import org.cinema.repository.GeneralRepo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class MovieService {
    @Inject
    private final GeneralRepo repo;

    public List<Movie> getMoviesByGenre(String genre) throws GenreNotFoundException {
        if (Arrays.stream(Genre.values()).noneMatch(g -> g.name().equals(genre))) {
            throw new GenreNotFoundException("Genre doesn't exist");
        }
        return repo.getMovies().stream()
                .filter(m -> m.getGenres().contains(Genre.valueOf(genre)))
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesByRating(Rating rating){
        return repo.getMovies().stream()
                .filter(m -> m.getRating().equals(rating))
                .collect(Collectors.toList());
    }

    
}
