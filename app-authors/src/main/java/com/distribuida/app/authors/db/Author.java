package com.distribuida.app.authors.db;

import jakarta.persistence.*;
import lombok.Data;

import lombok.var;

@Entity
@Table(name="authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Integer id;

    @Column(name = "auth_first_name")
    private String firstName;

    @Column(name = "auth_last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
	        name = "authors_books",
	        joinColumns = @JoinColumn(name = "auth_id"),
	        inverseJoinColumns = @JoinColumn(name = "book_id")
	    )
    private var books;

}
