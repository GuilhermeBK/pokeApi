package com.br.desafiopokeapi.vo;

public class PokemonWithHighlight{

    private String name;
    private String highlight;

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonWithHighlight(Pokemon pokemon, String name) {
        this.highlight = pokemon.getName().replace(name, "<pre>" + name + "</pre>");
        this.name = pokemon.getName();

    }
}
