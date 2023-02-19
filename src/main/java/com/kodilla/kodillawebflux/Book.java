package com.kodilla.kodillawebflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;

}
