package com.br.desafiopokeapi.controller;

import com.br.desafiopokeapi.cache.GenericCacheImpl;
import com.br.desafiopokeapi.service.RestService;
import com.br.desafiopokeapi.vo.Pokemon;
import com.br.desafiopokeapi.vo.Pokemons;
import com.br.desafiopokeapi.vo.ResultDto;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final RestService restService;

    private final GenericCacheImpl<String, Pokemons> cache;


    public PokemonController(RestService restService, GenericCacheImpl<String, Pokemons> cache) {
        this.restService = restService;
        this.cache = cache;
    }
    @GetMapping()
    public ResponseEntity<ResultDto<Pokemon>> listForNameWithHigh(@RequestParam(required = true) String name,
                                                          @RequestParam(required = false, defaultValue = "20") Long limit,
                                                          @RequestParam(required = false, defaultValue = "crescent") String order){

        return restService.getForPokemon(name, limit, order);

    }
    @GetMapping("/highlight")
    public ResponseEntity<ResultDto<Pokemon>> listForName(@RequestParam(required = true) String name,
                                                           @RequestParam(required = false, defaultValue = "20") Long limit,
                                                           @RequestParam(required = false, defaultValue = "") String order){

//        return this.cache.get(name).orElseGet(() -> restService.getForPokemonWithH(name, limit, order));


        return restService.getForPokemonWithH(name, limit, order);

    }

}
