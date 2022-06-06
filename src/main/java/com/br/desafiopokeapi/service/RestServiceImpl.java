package com.br.desafiopokeapi.service;

import com.br.desafiopokeapi.cache.GenericCacheImpl;
import com.br.desafiopokeapi.classification.Classification;
import com.br.desafiopokeapi.request.Request;
import com.br.desafiopokeapi.util.RestTemplateHelper;
import com.br.desafiopokeapi.vo.Pokemons;
import com.br.desafiopokeapi.vo.ResultDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements RestService{
    private static final String URL_LISTA_POKEMON = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1000";

    private final Classification classification;

    private final ResultDto resultDto;

    private final RestTemplateHelper helper;

    private final GenericCacheImpl<String, Pokemons> cache;

    private final Request request;

    public RestServiceImpl(Classification classification, ResultDto resultDto, RestTemplateHelper helper, GenericCacheImpl<String, Pokemons> cache, Request request) {
        this.classification = classification;
        this.resultDto = resultDto;
        this.helper = helper;
        this.cache = cache;
        this.request = request;
    }

    @Override
    public ResponseEntity getForPokemon(String name, Long limit, String order) {


        try {
            ResponseEntity<Pokemons> response = helper.getInstance().exchange(URL_LISTA_POKEMON, HttpMethod.GET,
                    helper.getHttpEntity(helper.getHeaders()), Pokemons.class);

            resultDto.setResult(classification.classificaPokemonForName(response, name, limit, order));



            return ResponseEntity.ok(resultDto);
        }catch (Exception exception) {

            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }



    @Override
    public ResponseEntity getForPokemonWithH(String name, Long limit, String order) {

        try {
            ResponseEntity<Pokemons> response = request.getPokemonsResponseEntity(URL_LISTA_POKEMON, helper.getHttpEntity(helper.getHeaders()));

            resultDto.setResult(classification.classificaPokemonForNameWithHigh(response, name, limit, order));

            this.cache.put(name, response.getBody());

            return ResponseEntity.ok(resultDto);
        }catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
