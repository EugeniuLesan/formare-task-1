package org.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rating {
    ONE_STAR("⭐"),
    TWO_STARS("⭐⭐"),
    THREE_STARS("⭐⭐⭐"),
    FOUR_STARS("⭐⭐⭐⭐"),
    FIVE_STARS("⭐⭐⭐⭐⭐");

    private final String stars;
}
