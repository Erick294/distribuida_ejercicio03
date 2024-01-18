package com.distribuida.app.books.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "book_isbn")
    private String isbn;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_price")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
	        name = "books_authors",
	        joinColumns = @JoinColumn(name = "book_id"),
	        inverseJoinColumns = @JoinColumn(name = "auth_id")
	    )
    private Integer authorId;
}
