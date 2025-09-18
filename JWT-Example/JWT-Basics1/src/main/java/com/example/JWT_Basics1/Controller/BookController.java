package com.example.JWT_Basics1.Controller;
import com.example.JWT_Basics1.Entity.Book;
import com.example.JWT_Basics1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping("/books")
        public List<Book> getAllBooks() {
            return bookService.getAllBooks();
        }


        @PostMapping("/addBook")
        public ResponseEntity<Book> createBook(@RequestBody Book book) {
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.ok(savedBook);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBook(@PathVariable int id) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }

}

