package org.cinema.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Movie {
    private String title;
    private LocalDate releaseDate;
    private LocalTime movieLength;
    private Rating rating;
    private List<Actor> actors;
    private Director director;
    private List<Genre> genres;
}
