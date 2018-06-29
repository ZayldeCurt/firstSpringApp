package com.pokemon.service;

import com.pokemon.dto.AbilityDto;
import com.pokemon.dto.PokemonDto;
import com.pokemon.dto.TypeDto;


public interface PokemonService {

    public String getString(String endPoint,String id);
    public PokemonDto getPokemon(String endPoint,String id);
    public TypeDto getType(String endPoint,String id);
    public AbilityDto getAbility(String endPoint,String id);


}
