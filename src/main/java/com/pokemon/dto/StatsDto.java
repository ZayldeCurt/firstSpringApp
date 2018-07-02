package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatsDto {
    @JsonProperty("base_stat")
    private int baseStat;

    private String statName;

    @SuppressWarnings("unchecked")
    @JsonProperty("stat")
    private void unpackNested(Map<String,Object> stat) {
        this.statName = (String)stat.get("name");
    }

    public StatsDto(int baseStat) {
        this.baseStat = baseStat;
    }

    public StatsDto() {

    }

    public int isBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }
}
