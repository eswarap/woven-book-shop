package org.woven.bookshop.configservice.catalogservice.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(final String isbn) {
        super("Book with ISBN" + isbn + "was not found");
    }
}
