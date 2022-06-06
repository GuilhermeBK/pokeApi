package com.br.desafiopokeapi.classification;

import com.br.desafiopokeapi.vo.Pokemon;
import com.br.desafiopokeapi.vo.PokemonWithHighlight;
import com.br.desafiopokeapi.vo.Pokemons;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Classification {

    public List<Pokemon> classificaPokemonForName(ResponseEntity<Pokemons> response, String name, Long limit, String order);

    public List<PokemonWithHighlight> classificaPokemonForNameWithHigh(ResponseEntity<Pokemons> response, String name, Long limit, String order);

}
