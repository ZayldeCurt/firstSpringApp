package com.pokemon.service;

import com.pokemon.dto.*;

public class PokemonServiceImplTest implements PokemonService {
    @Override
    public String getString(String endPoint, String id) {
        return null;
    }

    @Override
    public PokemonDto getPokemon(String endPoint, String id) {
//        return new PokemonDto("bulbasaur",20);
        StatsDto[] statsDtos = new StatsDto[2];
        statsDtos[0] = new StatsDto(45,"speed");
        statsDtos[1] = new StatsDto(65,"special-defense");

        AbilitiesDto[] abilitiesDto = new AbilitiesDto[2];
        abilitiesDto[0] = new AbilitiesDto(true,3);
        abilitiesDto[1] = new AbilitiesDto(false,1);

        return new PokemonDto("bulbasaur",20,"bulbasaur",statsDtos,abilitiesDto);
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
