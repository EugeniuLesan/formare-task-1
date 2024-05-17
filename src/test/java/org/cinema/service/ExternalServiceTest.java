package org.cinema.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.cinema.exception.GenreNotFoundException;
import org.cinema.model.Genre;
import org.cinema.model.Movie;
import org.cinema.model.Rating;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@QuarkusTest
public class ExternalServiceTest {
    @Inject
    private ExternalService externalService;
    @Inject
    private MovieService movieService;

    @AfterEach
    public void inject() {
        externalService.setService(movieService);
    }

    @Test
    public void verifySameReturnForCalls() {
        List<Movie> list1 = externalService.getSortedMoviesByReleaseDate();
        List<Movie> list2 = externalService.getSortedMoviesByReleaseDate();
        Assertions.assertEquals(list1, list2);
    }

    @SneakyThrows
    @Test
    public void verifyResponseForDifferentParameter() {
        List<Movie> list1 = externalService.getMostRatedMoviesFromGenre(Genre.ACTION.name());
        List<Movie> list2 = externalService.getMostRatedMoviesFromGenre(Genre.DRAMA.name());
        Assertions.assertNotEquals(list1, list2);
    }

    @Test
    public void verifyException() {
        assertThrows(GenreNotFoundException.class, () -> {
            externalService.getMostRatedMoviesFromGenre("random-string");
        });
    }

    @SneakyThrows
    @Test
    public void getMostRatedMoviesFromGenre() {
        MovieService movieServiceMocked = Mockito.mock(MovieService.class);
        List<Movie> list = List.of(
                Movie.builder()
                        .title("The Action Movie")
                        .releaseDate(LocalDate.of(2023, 7, 10))
                        .movieLength(LocalTime.of(2, 15))
                        .rating(Rating.FIVE_STARS)
                        .actors(null)
                        .director(null)
                        .genres(List.of(Genre.ACTION, Genre.THRILLER))
                        .build(),
                Movie.builder()
                        .title("The Drama Movie")
                        .releaseDate(LocalDate.of(2023, 2, 15))
                        .movieLength(LocalTime.of(2, 0))
                        .rating(Rating.FIVE_STARS)
                        .actors(null)
                        .director(null)
                        .genres(List.of(Genre.DRAMA))
                        .build()
        );

        Mockito.when(movieServiceMocked.getMoviesByGenre(Mockito.anyString())).thenReturn(list);

        externalService.setService(movieServiceMocked);

        List<Movie> mostRatedMoviesFromGenre = externalService.getMostRatedMoviesFromGenre(randomGenre().name());

        Assertions.assertEquals(mostRatedMoviesFromGenre, list);

        verify(movieServiceMocked, times(1))
                .getMoviesByGenre(Mockito.anyString());
    }

    private Genre randomGenre() {
        Genre[] genres = Genre.values();
        Random random = new Random();
        return genres[random.nextInt(genres.length)];
    }
}
