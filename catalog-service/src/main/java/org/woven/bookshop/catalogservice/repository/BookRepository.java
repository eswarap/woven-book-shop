package org.woven.bookshop.catalogservice.repository;

import org.woven.bookshop.catalogservice.domain.Book;

import java.util.Optional;

public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(final String isbn);
    boolean existsByIsbn(final String isbn);
    Book save(final Book book);
    void deleteByIsbn(final String isbn);
}
