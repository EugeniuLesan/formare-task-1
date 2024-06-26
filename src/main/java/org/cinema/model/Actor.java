package org.cinema.model;

import lombok.*;

import java.time.LocalDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @Builder
    @EqualsAndHashCode
    public class Actor {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
    }
