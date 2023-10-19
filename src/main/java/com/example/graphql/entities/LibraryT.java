package com.example.graphql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryT {
    private String id;
    private String bookId;
    private String nome;

}
