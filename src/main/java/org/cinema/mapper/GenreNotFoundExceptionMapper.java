package org.cinema.mapper;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.cinema.dto.ErrorMessage;
import org.cinema.exception.GenreNotFoundException;

@Provider
public class GenreNotFoundExceptionMapper implements ExceptionMapper<GenreNotFoundException> {
    @Override
    public Response toResponse(GenreNotFoundException exception) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(exception.getMessage())
                .status(Response.Status.BAD_REQUEST)
                .build();
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
