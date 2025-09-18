package com.example.JWT_Basics1.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        int book_id;

        @Setter
        @Getter
        @Column
        String title;

        public int getId() {
            return book_id;
        }

        public void setId(int book_id) {
            this.book_id = book_id;
        }


}

