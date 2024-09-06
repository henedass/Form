package com.example.hw;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET a single book by ISBN
    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);  // In a real app, throw exception if not found
    }

    // POST to add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // PUT to update a book by ISBN
    @PutMapping("/{isbn}")
    public Book updateBook(@PathVariable String isbn, @RequestBody Book updatedBook) {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
        return book;  // In a real app, handle if not found
    }

    // DELETE to remove a book by ISBN
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}
