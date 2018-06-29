package com.pokemon.unit;

import com.pokemon.service.PokemonService;
import com.pokemon.service.PokemonServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

public class PokemonServiceTest {

    PokemonService pokemonService = new PokemonServiceImplTest();

    @Test
    public void shouldReturnBulbasaur(){
        Assert.assertEquals(pokemonService.getPokemon("pokemon","test").getName(),"bulbasaur");
    }

    @Test
    public void shouldNotReturnBulbasaur(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getName(),"bu");
    }

}
