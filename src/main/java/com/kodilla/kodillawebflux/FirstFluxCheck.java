package com.kodilla.kodillawebflux;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class FirstFluxCheck {

    public static Logger logger = LoggerFactory.getLogger(FirstFluxCheck.class);

    public static void main(String[] args) {
        logger.info("Start");
        Book b1 = new Book("Title1", "Author1", 2000);
        Book b2 = new Book("Title2", "Author2", 2001);
        Flux<Book> bookFlux = Flux.just(b1, b2);
        bookFlux = bookFlux.concatWith(Flux.error(new Exception("Test exception")));
        logger.info("Books:");
        bookFlux.subscribe(System.out::println, FirstFluxCheck::handleException);
    }

    private static void handleException(Throwable e) {
        System.out.println("There was an error: " + e);
    }

}
