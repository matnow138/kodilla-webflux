package com.kodilla.kodillawebflux.controller;

import com.kodilla.kodillawebflux.Book;
import com.kodilla.kodillawebflux.BookDto;
import com.kodilla.kodillawebflux.BookMapper;
import com.kodilla.kodillawebflux.FirstFluxCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@RestController
public class FluxController {

    @Autowired
    private BookMapper bookMapper;
    public static Logger logger = LoggerFactory.getLogger(FirstFluxCheck.class);

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping("/bookDto")
    public Flux<BookDto> getBookDto() {
        Book b1 = new Book("Title1", "Author1", 2000);
        BookDto bookDto = bookMapper.mapToBookDto(b1);
        Flux<BookDto> bookFlux = Flux.just(bookDto);
        bookFlux.subscribe(System.out::println);
        return bookFlux;

    }
}
