package com.example.BookProject.Service;

import com.example.BookProject.Entity.Book;
import com.example.BookProject.Repository.BookRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService
{
@Autowired
BookRepository bookRepository;

public Book addBook(Book book)
{
    return bookRepository.save(book);
}
public Book getBookByName(String name)
{
  return bookRepository.findBookByTitle(name);
}
public Book updateBook(Book book)
{

    return bookRepository.save(book);
}
public void deleteBook(Integer id)
{
    bookRepository.deleteById(id);
}
}
