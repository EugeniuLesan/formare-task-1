package org.cinema.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.ws.rs.core.Response;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorMessage {
    private final String message;
    private final Response.Status status;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
    private final LocalDateTime time = LocalDateTime.now();

    public ErrorMessage(String message, Response.Status httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }
}
