package com.br.desafiopokeapi.classification;

import com.br.desafiopokeapi.vo.Pokemon;
import com.br.desafiopokeapi.vo.PokemonWithHighlight;
import com.br.desafiopokeapi.vo.Pokemons;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificationHelper implements Classification{



    @Override
    public List<Pokemon> classificaPokemonForName(ResponseEntity<Pokemons> response, String name, Long limit, String order) {
        List<Pokemon> listPokemon = new LinkedList<>();
        for (Pokemon pokemon : response.getBody().getPokemons()) {
            if (pokemon.getName().toUpperCase().contains(name.toUpperCase())) {
                listPokemon.add(pokemon);
                if (order.equals("descending"))
                    listPokemon.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                else if (order.equals("crescent"))
                    listPokemon.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
            }
        }

        return listPokemon.stream().limit(limit).collect(Collectors.toList());
    }


    @Override
    public List<PokemonWithHighlight> classificaPokemonForNameWithHigh(ResponseEntity<Pokemons> response, String name, Long limit, String order) {
        List<PokemonWithHighlight> listPokemon = new LinkedList<>();
        for (Pokemon pokemon : response.getBody().getPokemons()) {
            if (pokemon.getName().toUpperCase().contains(name.toUpperCase())) {
                PokemonWithHighlight pokemonWithHighlight = new PokemonWithHighlight(pokemon, name);
                listPokemon.add(pokemonWithHighlight);
                if (order.equals(""))
                    listPokemon.sort((o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length()));
                else if (order.equals("length"))
                    listPokemon.sort((o1, o2) -> Integer.compare(o2.getName().length(), o1.getName().length()));
            }
        }



        return listPokemon.stream().limit(limit).collect(Collectors.toList());
    }
}
