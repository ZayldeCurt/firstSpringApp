package com.pokemon.service;

import com.pokemon.dto.AbilityDto;
import com.pokemon.dto.PokemonDto;
import com.pokemon.dto.TypeDto;

public class PokemonServiceImplTest implements PokemonService {
    @Override
    public String getString(String endPoint, String id) {
        return null;
    }

    @Override
    public PokemonDto getPokemon(String endPoint, String id) {
        return new PokemonDto("bulbasaur","20");
    }

    @Override
    public TypeDto getType(String endPoint, String id) {
        return null;
    }

    @Override
    public AbilityDto getAbility(String endPoint, String id) {
        return null;
    }
}
