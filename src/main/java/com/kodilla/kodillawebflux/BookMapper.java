package com.kodilla.kodillawebflux;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getYear());
    }
}
