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


    /*
    * classifica o nome dos pokemons pela variavel "name" passada como parametro,
    * pega todos os pokemons que contém a variavel passada
    *
    * Varre o body do response, se o nome do pokemon conter os caracteres passados na string,
    * adiciona a lista
    *
    * depois verifica se a variavel order é "descending" ou "crescent" o ordena a lista conforme.
    *
    * Retorna a lista usando o limit passado como parametro
    * */
    @Override
    public List<Pokemon> classificaPokemonForName(ResponseEntity<Pokemons> response, String name, Long limit, String order) {
        List<Pokemon> listPokemon = new LinkedList<>();
        for (Pokemon pokemon : response.getBody().getPokemons()) {
            if (pokemon.getName().toUpperCase().contains(name.toUpperCase())) {
                listPokemon.add(pokemon);
            }
        }
        if (order.equals("descending"))
            listPokemon.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        else if (order.equals("crescent"))
            listPokemon.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));

        return listPokemon.stream().limit(limit).collect(Collectors.toList());
    }


    /*
    * Classifica o nome e envolve a substring da pesquisa pela tag <pre>

    * Varre o response da request, verifica se no nome contem a variavel "name"
    * se existir, instancia o obj passando como parametro o objeto pokemon e a variavel "name"
    * para que possa ser envolvidas pela tag <pre> e setada na variavel "WithHighlight"
    *
    * adiciona o obj instanciado em uma lista e depois verifica a variavel "order" para ordenar pelo tamanho da string
    * se vazia, ordena crescente, se order="length", ordena por decrescente
    *
    * Retorna a lista limitando o resultado pela variavel "limit" passada como parametro
     * */
    @Override
    public List<PokemonWithHighlight> classificaPokemonForNameWithHigh(ResponseEntity<Pokemons> response, String name, Long limit, String order) {
        List<PokemonWithHighlight> listPokemon = new LinkedList<>();
        for (Pokemon pokemon : response.getBody().getPokemons()) {
            if (pokemon.getName().toUpperCase().contains(name.toUpperCase())) {
                PokemonWithHighlight pokemonWithHighlight = new PokemonWithHighlight(pokemon, name);
                listPokemon.add(pokemonWithHighlight);
            }
        }
        if (order.equals(""))
            listPokemon.sort((o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length()));
        else if (order.equals("length"))
            listPokemon.sort((o1, o2) -> Integer.compare(o2.getName().length(), o1.getName().length()));



        return listPokemon.stream().limit(limit).collect(Collectors.toList());
    }
}
