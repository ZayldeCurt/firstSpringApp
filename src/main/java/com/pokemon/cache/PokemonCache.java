package com.pokemon.cache;

import com.pokemon.dto.PokemonDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonCache {
    public List<PokemonDto> pokemonDtosList;

    @PostConstruct
    public void methodInit() {
        pokemonDtosList = new ArrayList<>();
    }

    public void add(PokemonDto pokemonDto) {
        boolean isExist = pokemonDtosList.contains(pokemonDto);
        if(isExist){
            pokemonDtosList.add(pokemonDto);
        }
    }
}