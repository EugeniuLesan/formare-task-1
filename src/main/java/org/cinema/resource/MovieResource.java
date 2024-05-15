package org.cinema.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.cinema.exception.GenreNotFoundException;
import org.cinema.service.MovieService;

@ApplicationScoped
@Path("/api/v1/movie")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
    @Inject
    private final MovieService service;

    @GET
    public Response getMoviesByGenre(@QueryParam("genre") String genre) throws GenreNotFoundException {
        return Response.ok(service.getMoviesByGenre(genre)).build();
    }
}
