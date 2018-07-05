package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
//TODO http://www.baeldung.com/jackson-nested-values


public class PokemonDto {

    private String name;
    private int weight;
    private String speciesName;
    private int id;

    @SuppressWarnings("unchecked")
    @JsonProperty("brand")
    private void unpackNested(Map<String,Object> species) {
        this.speciesName = (String)species.get("name");
    }

    @JsonProperty("stats")
    private StatsDto[] stats;

    @JsonProperty("abilities")
    private AbilitiesDto[] abilities;

    public PokemonDto() {
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
    public PokemonDto(String name, int weight, String speciesName, StatsDto[] stats, AbilitiesDto[] abilities) {
        this.name = name;
        this.weight = weight;
        this.speciesName = speciesName;
        this.stats = stats;
        this.abilities = abilities;
    }

    public PokemonDto(String name, int weight, String speciesName, int id, StatsDto[] stats, AbilitiesDto[] abilities) {
        this.name = name;
        this.weight = weight;
        this.speciesName = speciesName;
        this.id = id;
        this.stats = stats;
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDto that = (PokemonDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public StatsDto[] getStats() {
        return stats;
    }

    public void setStats(StatsDto[] stats) {
        this.stats = stats;
    }

    public AbilitiesDto[] getAbilities() {
        return abilities;
    }

    public void setAbilities(AbilitiesDto[] abilities) {
        this.abilities = abilities;
    }


}



