package com.bookstore.book;

import com.bookstore.book.dto.BookDto;
import com.bookstore.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public ResponseEntity<Book> createBook(BookDto book) {
        Book newBook = Book.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .price(book.getPrice())
                .publicationDate(book.getPublicationDate())
                .build();
        bookRepository.save(newBook);
        return ResponseEntity.ok(newBook);
    }

    public ResponseEntity<Optional<Book>> findBookById(UUID bookId) {
        Optional<Book> book = Optional.of(bookRepository.findById(bookId))
                .orElseThrow(() -> new NotFoundException("Book does not exists."));

        return ResponseEntity.ok(book);
    }



}
