package org.woven.bookshop.configservice.catalogservice.service;

import org.springframework.stereotype.Service;
import org.woven.bookshop.configservice.catalogservice.domain.Book;
import org.woven.bookshop.configservice.catalogservice.exception.BookAlreadyExistsException;
import org.woven.bookshop.configservice.catalogservice.exception.BookNotFoundException;
import org.woven.bookshop.configservice.catalogservice.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(final String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(()->new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(final Book book) {
        if (bookRepository.existsByIsbn(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(final String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(final String isbn, final Book book) {
        return bookRepository.findByIsbn(isbn).map(
                existingBook -> {
                    var bookToUpdate = new Book(existingBook.id(),
                            existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price(),
                            existingBook.createdDate(),
                            existingBook.modifiedDate(),
                            existingBook.version());
                    return bookRepository.save(bookToUpdate);
                }
        ).orElseGet(()->addBookToCatalog(book));
    }
}
