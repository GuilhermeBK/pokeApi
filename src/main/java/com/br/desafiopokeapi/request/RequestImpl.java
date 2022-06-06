package com.br.desafiopokeapi.request;

import com.br.desafiopokeapi.util.RestTemplateHelper;
import com.br.desafiopokeapi.vo.Pokemons;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestImpl implements Request{

    private final RestTemplateHelper helper;

    public RequestImpl(RestTemplateHelper helper) {
        this.helper = helper;
    }



    @Override
    public ResponseEntity<Pokemons> getPokemonsResponseEntity(String URL_LISTA_POKEMON, HttpEntity httpEntity) {
        ResponseEntity<Pokemons> response = helper.getInstance().exchange(URL_LISTA_POKEMON, HttpMethod.GET,
                httpEntity, Pokemons.class);
        return response;
    }
}
