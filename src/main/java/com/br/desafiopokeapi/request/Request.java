package com.br.desafiopokeapi.request;

import com.br.desafiopokeapi.vo.Pokemons;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

/*
* Interface usada para requisições
* */

public interface Request {



    public ResponseEntity<Pokemons> getPokemonsResponseEntity(String URL_LISTA_POKEMON, HttpEntity httpEntity);

}
