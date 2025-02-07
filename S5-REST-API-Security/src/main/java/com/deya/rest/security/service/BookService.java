package com.deya.rest.security.service;


import com.deya.rest.security.entity.Book;
import com.deya.rest.security.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }
}
