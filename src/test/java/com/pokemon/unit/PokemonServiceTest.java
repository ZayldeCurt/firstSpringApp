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

    @Test
    public void shouldReturnSpecies(){
        Assert.assertEquals(pokemonService.getPokemon("pokemon","test").getSpeciesName(),"bulbasaur");
    }

    @Test
    public void shouldNotReturnSpecies(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getSpeciesName(),"bu");
    }

    @Test
    public void shouldReturnStats(){
        Assert.assertEquals(pokemonService.getPokemon("pokemon","test").getStats()[0].getBaseStat(),45);
        Assert.assertEquals(pokemonService.getPokemon("pokemon","test").getStats()[0].getStatName(),"speed");
    }

    @Test
    public void shouldNotReturnBaseStat(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getStats()[0].getBaseStat(),12);
    }
    @Test
    public void shouldNotReturnStatsName(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getStats()[0].getStatName(),"s");
    }

    @Test
    public void shouldReturnAbilities(){
        Assert.assertEquals(pokemonService.getPokemon("pokemon","test").getAbilities()[0].getSlot(),3);
        Assert.assertTrue(pokemonService.getPokemon("pokemon","test").getAbilities()[0].isHidden());
    }

    @Test
    public void shouldNotReturnAbilitiesIsHidden(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getAbilities()[0].isHidden(),false);
    }

    @Test
    public void shouldNotReturnAbilitiesSlot(){
        Assert.assertNotEquals(pokemonService.getPokemon("pokemon","test").getAbilities()[0].getSlot(),2);
    }
}
