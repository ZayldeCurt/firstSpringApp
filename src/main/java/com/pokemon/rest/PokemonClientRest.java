package com.pokemon.rest;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//adnotacje Springa
//@Service //zostanie przy starcie utworzona pojedyńcza instancja, najczęściej używana, podstawowa //dodatkowo dodaje static do method
@RestController //mówi że tu będzie klasa świadcząca usługi restowe, czyli po http
public class PokemonClientRest {
    //ta klasa ma udostępnić endPoint
    //zczytamy z Pokemon i wyświetlimy jako swoje już

    private PokemonService pokemonService;

    @Autowired
    public PokemonClientRest(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

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

//    @RequestMapping("/{endPoint}/{id}")
//    public TypeDto getOurType(@PathVariable(value = "endPoint") String endPoint,@PathVariable(value = "id") String id) {
//
//        if (endPoint.equals("type")) {
//            TypeDto typeDto = pokemonService.getType(endPoint, id);
//            return typeDto;
//        }
//        return null;
//    }
//
//    @RequestMapping("/{endPoint}/{id}")
//    public AbilityDto getOurAbility(@PathVariable(value = "endPoint") String endPoint,@PathVariable(value = "id") String id) {
//
//        if (endPoint.equals("type")) {
//            AbilityDto abilityDto = pokemonService.getAbility(endPoint, id);
//            return abilityDto;
//        }
//        return null;
//    }

}
