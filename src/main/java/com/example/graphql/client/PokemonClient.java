package com.example.graphql.client;

import com.example.graphql.entities.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "pokemonclient", url = "https://pokeapi.co/api/v2/")
public interface PokemonClient {

    @GetMapping("pokemon/ditto")
    Pokemon getPokemon();

}
