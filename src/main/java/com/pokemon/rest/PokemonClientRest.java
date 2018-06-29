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
    public String getOurPokemon(@PathVariable(value = "endPoint") String endPoint,@PathVariable(value = "id") String id){

//        String result = pokemonService.getString(endPoint,id);

//        if(endPoint.equals("pokemon")){
//            PokemonDto pokemonDto = pokemonService.getPokemon(result);
//            String pokemonName = result.split(",\"name\":\"")[1].split("\"}],")[0];
//            return pokemonName;
//        }
//        return result;

        switch (endPoint){
            case "pokemon":
                PokemonDto pokemonDto = pokemonService.getPokemon(endPoint, id);
                return pokemonDto.getName();
//                break;
            case "type":
                TypeDto typeDto = pokemonService.getType(endPoint, id);
                return typeDto.getName();
//                break;
            case "ability":
                AbilityDto abilityDto = pokemonService.getAbility(endPoint, id);
                return  abilityDto.getName();
//                break;
            default:
                break;
        }
        return null;
//       if(endPoint.equals("pokemon")) {
//           PokemonDto pokemonDto = pokemonService.getPokemon(endPoint, id);
//           return pokemonDto.getName();
//       }else {
//           String result = pokemonService.getString(endPoint,id);
//           return result;
//       }
    }

}
