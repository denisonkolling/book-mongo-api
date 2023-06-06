package com.mongo.book.controller;
import com.mongo.book.model.Book;
import com.mongo.book.service.BookService;
import com.mongo.book.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok().body(bookService.getAll());
    }

    @RequestMapping(path = "/books/{criteria}/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getByCriteria(@PathVariable String criteria, @PathVariable String search) {
        return ResponseEntity.ok().body(bookService.getByCriteria(criteria, search));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(bookService.getById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.create(book));
    }

    @PutMapping("/books")
    public ResponseEntity<Boolean> update(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.update(book));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.ok().body(bookService.delete(id));
    }
}
