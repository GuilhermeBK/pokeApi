package com.br.desafiopokeapi.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pokemons {
    @JsonProperty(value = "results")
    private List<Pokemon> pokemons;



    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
