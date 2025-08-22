package com.example.BookProject.Controller;

import com.example.BookProject.Entity.Book;
import com.example.BookProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

private final  BookService bookservice;
    @Autowired
    public BookController(BookService bookservice) {
        this.bookservice = bookservice;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
     {
         Book savedBook=bookservice.addBook(book);
         return ResponseEntity.ok(savedBook);
     }
     @GetMapping("/getBook/{bookName}")
    public Book getBookByName(@PathVariable("bookName") String name)
     {
     Book bookByName  =  bookservice.getBookByName(name);
     return bookByName;
     }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book)
    {
        Book updatedBook=bookservice.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") Integer id)
    {
     bookservice.deleteBook(id);


    }

}
