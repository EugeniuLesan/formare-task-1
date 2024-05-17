package org.cinema.repository;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.cinema.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Getter
@NoArgsConstructor
public class GeneralRepo {
    private List<Movie> movies;
    private List<Director> directors;
    private List<Actor> actors;

    @PostConstruct
    protected void init() {
        // actors
        Actor actor1 = Actor.builder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.of(1980, 5, 15))
                .build();
        Actor actor2 = Actor.builder()
                .firstName("Jane")
                .lastName("Smith")
                .birthDate(LocalDate.of(1990, 10, 25))
                .build();
        Actor actor3 = Actor.builder()
                .firstName("Michael")
                .lastName("Williams")
                .birthDate(LocalDate.of(1978, 9, 8))
                .build();
        Actor actor4 = Actor.builder()
                .firstName("Emily")
                .lastName("Jones")
                .birthDate(LocalDate.of(1987, 4, 12))
                .build();
        Actor actor5 = Actor.builder()
                .firstName("David")
                .lastName("Brown")
                .birthDate(LocalDate.of(1995, 8, 30))
                .build();

        // directors
        Director director1 = Director.builder()
                .firstName("Michael")
                .lastName("Johnson")
                .birthDate(LocalDate.of(1975, 8, 20))
                .build();
        Director director2 = Director.builder()
                .firstName("Emily")
                .lastName("Davis")
                .birthDate(LocalDate.of(1985, 3, 12))
                .build();
        Director director3 = Director.builder()
                .firstName("David")
                .lastName("Miller")
                .birthDate(LocalDate.of(1970, 12, 30))
                .build();
        Director director4 = Director.builder()
                .firstName("Sarah")
                .lastName("Wilson")
                .birthDate(LocalDate.of(1983, 10, 5))
                .build();
        Director director5 = Director.builder()
                .firstName("James")
                .lastName("Anderson")
                .birthDate(LocalDate.of(1965, 7, 18))
                .build();

        // movies
        Movie movie1 = Movie.builder()
                .title("The Action Movie")
                .releaseDate(LocalDate.of(2023, 7, 10))
                .movieLength(LocalTime.of(2, 15))
                .rating(Rating.FOUR_STARS)
                .actors(List.of(actor1, actor2))
                .director(director1)
                .genres(List.of(Genre.ACTION, Genre.THRILLER))
                .build();
        Movie movie2 = Movie.builder()
                .title("The Comedy Movie")
                .releaseDate(LocalDate.of(2022, 12, 5))
                .movieLength(LocalTime.of(1, 45))
                .rating(Rating.THREE_STARS)
                .actors(List.of(actor2))
                .director(director2)
                .genres(List.of(Genre.COMEDY))
                .build();
        Movie movie3 = Movie.builder()
                .title("The Drama Movie")
                .releaseDate(LocalDate.of(2023, 2, 15))
                .movieLength(LocalTime.of(2, 0))
                .rating(Rating.FIVE_STARS)
                .actors(List.of(actor1, actor3))
                .director(director3)
                .genres(List.of(Genre.DRAMA))
                .build();
        Movie movie4 = Movie.builder()
                .title("The Horror Movie")
                .releaseDate(LocalDate.of(2024, 5, 20))
                .movieLength(LocalTime.of(1, 50))
                .rating(Rating.FOUR_STARS)
                .actors(List.of(actor4, actor5))
                .director(director4)
                .genres(List.of(Genre.HORROR, Genre.THRILLER))
                .build();
        Movie movie5 = Movie.builder()
                .title("The Romance Movie")
                .releaseDate(LocalDate.of(2023, 9, 8))
                .movieLength(LocalTime.of(2, 5))
                .rating(Rating.FOUR_STARS)
                .actors(List.of(actor2, actor3))
                .director(director5)
                .genres(List.of(Genre.ROMANCE))
                .build();
        Movie movie6 = Movie.builder()
                .title("The Science Fiction Movie")
                .releaseDate(LocalDate.of(2024, 3, 15))
                .movieLength(LocalTime.of(2, 20))
                .rating(Rating.FIVE_STARS)
                .actors(List.of(actor1, actor4))
                .director(director1)
                .genres(List.of(Genre.SCIENCE_FICTION, Genre.ACTION))
                .build();
        Movie movie7 = Movie.builder()
                .title("The Thriller Movie")
                .releaseDate(LocalDate.of(2023, 11, 30))
                .movieLength(LocalTime.of(1, 55))
                .rating(Rating.FOUR_STARS)
                .actors(List.of(actor5))
                .director(director2)
                .genres(List.of(Genre.THRILLER))
                .build();
        Movie movie8 = Movie.builder()
                .title("The Adventure Movie")
                .releaseDate(LocalDate.of(2024, 8, 12))
                .movieLength(LocalTime.of(2, 10))
                .rating(Rating.FIVE_STARS)
                .actors(List.of(actor3, actor4))
                .director(director3)
                .genres(List.of(Genre.ADVENTURE, Genre.ACTION))
                .build();
        Movie movie9 = Movie.builder()
                .title("The Mystery Movie")
                .releaseDate(LocalDate.of(2023, 4, 25))
                .movieLength(LocalTime.of(2, 5))
                .rating(Rating.THREE_STARS)
                .actors(List.of(actor2, actor5))
                .director(director4)
                .genres(List.of(Genre.MYSTERY))
                .build();
        Movie movie10 = Movie.builder()
                .title("The Fantasy Movie")
                .releaseDate(LocalDate.of(2024, 1, 10))
                .movieLength(LocalTime.of(2, 30))
                .rating(Rating.FOUR_STARS)
                .actors(List.of(actor1, actor3, actor4))
                .director(director5)
                .genres(List.of(Genre.FANTASY))
                .build();

        this.actors = new ArrayList<>(List.of(actor1, actor2, actor3, actor4, actor5));
        this.directors = new ArrayList<>(List.of(director1, director2, director3, director4, director5));
        this.movies = new ArrayList<>(List.of(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10));
    }


}
