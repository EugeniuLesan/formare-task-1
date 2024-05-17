package org.cinema.util;

import jakarta.enterprise.context.ApplicationScoped;
import org.cinema.model.Movie;

import java.util.Comparator;

@ApplicationScoped
public class MovieComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getReleaseDate().compareTo(m2.getReleaseDate());
    }
}
