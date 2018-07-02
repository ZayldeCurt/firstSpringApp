package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
//TODO http://www.baeldung.com/jackson-nested-values


public class PokemonDto {

    private String name;
    private int weight;
    private String speciesName;

    @SuppressWarnings("unchecked")
    @JsonProperty("brand")
    private void unpackNested(Map<String,Object> species) {
        this.speciesName = (String)species.get("name");
//        Map<String,String> owner = (Map<String,String>)species.get("owner");
//        this.ownerName = owner.get("name");
    }

    @JsonProperty("stats")
    private StatsDto[] stats;

    @JsonProperty("abilities")
    private AbilitiesDto[] abilities;

    public PokemonDto() {
    }

    public String getName() {

        return name;
    }

    public PokemonDto(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public PokemonDto(String name, int weight, String speciesName) {
        this.name = name;
        this.weight = weight;
        this.speciesName = speciesName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }


}



