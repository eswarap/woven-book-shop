package org.woven.bookshop.configservice.catalogservice.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(final String isbn) {
        super("Book with ISBN "+isbn+"already exists");
    }
}
