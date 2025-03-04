package com.graphql.server.controller;

import com.graphql.server.data.Author;
import com.graphql.server.data.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @MutationMapping
    public Author addNewAuthor(
            @Argument String id,
            @Argument String firstName,
            @Argument String lastName
    ) {
        Author newAuthor = new Author(id, firstName, lastName);
        System.out.println(newAuthor);

        return newAuthor;
    }
}
