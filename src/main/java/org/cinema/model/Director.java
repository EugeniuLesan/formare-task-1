package org.cinema.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Director {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
