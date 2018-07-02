package com.pokemon.rest;

import com.pokemon.cache.PokemonCache;
import com.pokemon.dto.AbilityDto;
import com.pokemon.dto.PokemonDto;
import com.pokemon.dto.TypeDto;
import com.pokemon.service.PokemonService;
import com.pokemon.service.PokemonServiceImp;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

//adnotacje Springa
//@Service //zostanie przy starcie utworzona pojedyńcza instancja, najczęściej używana, podstawowa //dodatkowo dodaje static do method
@RestController //mówi że tu będzie klasa świadcząca usługi restowe, czyli po http
public class PokemonClientRest {
    //ta klasa ma udostępnić endPoint
    //zczytamy z Pokemon i wyświetlimy jako swoje już

    private PokemonService pokemonService;
    private PokemonCache pokemonCache;

    @Autowired
    public PokemonClientRest(PokemonService pokemonService, PokemonCache pokemonCache) {
        this.pokemonService = pokemonService;
        this.pokemonCache = pokemonCache;
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/{endPoint}/{id}")//aby była widoczna jako usługa restowa, wystawia jako endpoint,
    // dzieki temu będzie ta funkcja widoczna z localhost:8080
    public PokemonDto getOurPokemon(@PathVariable(value = "endPoint") String endPoint,@PathVariable(value = "id") String id){

        if(endPoint.equals("pokemon")){
            PokemonDto pokemonDto = pokemonService.getPokemon(endPoint,id);
            return pokemonDto;
        }
        return null;

//        switch (endPoint){
//            case "pokemon":
//                T pokemonDto = pokemonService.getPokemon(endPoint, id);
//                return pokemonDto;
//
//            case "type":
//                TypeDto typeDto = pokemonService.getType(endPoint, id);
//                return typeDto;
//
//            case "ability":
//                AbilityDto abilityDto = pokemonService.getAbility(endPoint, id);
//                return  abilityDto;
//
//            default:
//                break;
//        }
//        return null;
    }

//    @PostMapping("/addPokemon")
//    public ResponseEntity<String> addPokemon(@RequestBody PokemonDto pokemonDto){
//
//        pokemonCache.add(pokemonDto);
//
//        return null;
//    }

}
