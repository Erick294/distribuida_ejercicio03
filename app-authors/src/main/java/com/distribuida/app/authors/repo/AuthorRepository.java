package com.distribuida.app.authors.repo;

import com.distribuida.app.authors.db.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuthorRepository implements PanacheRepositoryBase<Author,Integer> {
}
