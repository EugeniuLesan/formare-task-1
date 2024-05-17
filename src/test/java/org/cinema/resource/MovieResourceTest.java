package org.cinema.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.cinema.model.Genre;
import org.cinema.model.Movie;
import org.cinema.model.Rating;
import org.cinema.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestHTTPEndpoint(MovieResource.class)
@QuarkusTest
public class MovieResourceTest {
    @InjectMock
    private MovieService service;
    @Inject
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    public void getMoviesByGenre() {
        Movie movie = Movie.builder()
                .title("The Action Movie")
                .releaseDate(LocalDate.of(2023, 7, 10))
                .movieLength(LocalTime.of(2, 15))
                .rating(Rating.FOUR_STARS)
                .actors(null)
                .director(null)
                .genres(List.of(Genre.ACTION, Genre.THRILLER))
                .build();

        Mockito.when(service.getMoviesByGenre(Mockito.any())).thenReturn(List.of(movie));

        given()
                .when()
                .queryParam("genre", Genre.ACTION.name())
                .get()
                .then()
                .statusCode(200)
                .body(equalTo(objectMapper.writeValueAsString(List.of(movie))));

        verify(service, times(1)).getMoviesByGenre(Mockito.any());
    }

}
