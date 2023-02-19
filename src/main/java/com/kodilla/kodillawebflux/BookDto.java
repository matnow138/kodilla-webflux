package com.kodilla.kodillawebflux;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class BookDto {
    private final String title;
    private final String author;
    private final int year;
}
