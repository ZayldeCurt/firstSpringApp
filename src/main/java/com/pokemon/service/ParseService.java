package com.pokemon.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.AbilityDto;
import com.pokemon.dto.PokemonDto;
import com.pokemon.dto.TypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;



@Service
public class ParseService {
    @Autowired //to samo co @inject tylko inject jest ogolnie dla javy
    RestTemplate restTemplate;

    public PokemonDto parsePokemon(String content){
        ObjectMapper mapper = new ObjectMapper();
        PokemonDto pokemonDto = null;

        try {
            String jsonInString = content;

            pokemonDto = mapper.readValue(jsonInString, PokemonDto.class);
            String prettyPokemonDto = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pokemonDto);
            System.out.println(prettyPokemonDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pokemonDto);
        return pokemonDto;
    }
    public TypeDto parseType(String content){
        ObjectMapper mapper = new ObjectMapper();
        TypeDto typeDto = null;

        try {
            String jsonInString = content;

            typeDto = mapper.readValue(jsonInString, TypeDto.class);
            String prettyPokemonDto = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(typeDto);
            System.out.println(prettyPokemonDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(typeDto);
        return typeDto;
    }

    public AbilityDto parseAbility(String content){
        ObjectMapper mapper = new ObjectMapper();
        AbilityDto abilityDto = null;

        try {
            String jsonInString = content;

            abilityDto = mapper.readValue(jsonInString, AbilityDto.class);
            String prettyPokemonDto = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(abilityDto);
            System.out.println(prettyPokemonDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(abilityDto);
        return abilityDto;
    }
}
