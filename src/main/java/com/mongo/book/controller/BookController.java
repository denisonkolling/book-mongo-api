package com.mongo.book.controller;
import com.mongo.book.model.Book;
import com.mongo.book.service.BookService;
import com.mongo.book.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping("/books")
@GetMapping("/")
public ResponseEntity<List<Book>> getAll() {
    return ResponseEntity.ok().body(bookService.getAll());
}

    @RequestMapping(path = "/books/{criteria}/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getByCriteria(@PathVariable String criteria, @PathVariable String search) {
        return ResponseEntity.ok().body(bookService.getByCriteria(criteria, search));
    }

//    @GetMapping("/books/{id}")
@GetMapping("/{id}")
public ResponseEntity<Book> getById(@PathVariable String id) {
    return ResponseEntity.ok().body(bookService.getById(id));
}

//    @PostMapping("/books")
@PostMapping("/saveBook")
public ResponseEntity<Book> create(@RequestBody Book book) {
    return ResponseEntity.ok().body(bookService.create(book));
}

//    @PutMapping("/books")
@PostMapping("/editBook/{id}")
    public ResponseEntity<Boolean> update(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.update(book));
    }

//    @DeleteMapping("/books/{id}")
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.ok().body(bookService.delete(id));
    }
}
