package com.example.BookProject.Repository;

import com.example.BookProject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book,Integer>
{
public Book findBookByTitle(String title);

}
