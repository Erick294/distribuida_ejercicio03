package com.distribuida.app.authors.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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


}
