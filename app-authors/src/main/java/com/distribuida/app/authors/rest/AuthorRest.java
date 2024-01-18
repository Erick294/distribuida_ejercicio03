package com.distribuida.app.authors.rest;

import com.distribuida.app.authors.db.Author;
import com.distribuida.app.authors.repo.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class AuthorRest {
    @Inject
    AuthorRepository repo;

    @GET
    public List<Author> findAll() {
        return repo.listAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Integer id) {
        var book = repo.findByIdOptional(id);

        if(book.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(book.get()).build();
    }

    @POST
    public Response create(Author obj) {
        obj.setId(null);

        repo.persist(obj);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id")Integer id, Author obj) {

        Author a = repo.findById(id);
        a.setId(obj.getId());
        a.setFirstName(obj.getFirstName());
        a.setLastName(obj.getLastName());

        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id")Integer id) {
        repo.deleteById(id);

        return Response.ok()
                .build();
    }
}
