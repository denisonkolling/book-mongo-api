package com.mongo.book.service;

import com.mongo.book.model.Book;
import com.mongo.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.regex;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Boolean delete(String id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getByCriteria(String criteria, String search) {
        Query query = new Query();
        query.addCriteria(Criteria.where(criteria).regex(String.format(".*%s.*", search), "i"));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    @Override
    public Book getById(String id) {

        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return book.get();
        }

        return null;
    }

    @Override
    public Boolean update(Book book) {
        Optional<Book> bookDb = bookRepository.findById(book.getId());

        if (bookDb.isPresent()) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}
