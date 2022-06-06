package com.br.desafiopokeapi.service;

import org.springframework.http.ResponseEntity;

public interface RestService {

    public ResponseEntity getForPokemon(String name, Long limit, String order);
    public ResponseEntity getForPokemonWithH(String name, Long limit, String order);

}
