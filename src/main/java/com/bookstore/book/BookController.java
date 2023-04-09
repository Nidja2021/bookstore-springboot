package com.bookstore.book;

import com.bookstore.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping
    public ResponseEntity<Book> getAllBooks(@RequestBody BookDto book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") UUID bookId) {
        return bookService.findBookById(bookId);
    }


}
