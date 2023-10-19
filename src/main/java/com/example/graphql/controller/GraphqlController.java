package com.example.graphql.controller;

import com.example.graphql.client.PokemonClient;
import com.example.graphql.entities.Author;
import com.example.graphql.entities.Book;
import com.example.graphql.entities.LibraryT;
import com.example.graphql.entities.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphqlController {

    private final PokemonClient pokemonClient;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @SchemaMapping
    public LibraryT library(Book book) {
        return buscarLivraria(book.getId());
    }

    @SchemaMapping
    public Pokemon pokemon(Book book) {
        return pokemonClient.getPokemon();
    }

    private LibraryT buscarLivraria(String bookId) {

        List<LibraryT> livrarias =
                List.of(
                        new LibraryT("library-1", "book-1", "livraria do filipe"),
                        new LibraryT("library-2", "book-2", "livraria do isaac"),
                        new LibraryT("library-3", "book-3", "livraria do bruno"));

        return livrarias.stream().filter(livraria -> livraria.getBookId().equals(bookId))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
