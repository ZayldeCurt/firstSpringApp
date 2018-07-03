package com.pokemon.cache;

import com.pokemon.dto.AbilitiesDto;
import com.pokemon.dto.AbilityDto;
import com.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonCache {
    public List<PokemonDto> pokemonDtosList;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void methodInit() {
        pokemonDtosList = new ArrayList<>();
    }

//    public void add(PokemonDto pokemonDto) { //działa
//        boolean isExist = pokemonDtosList.contains(pokemonDto);
//        if(!isExist){
//            pokemonDtosList.add(pokemonDto);
//        }
//    }

    public void add(PokemonDto pokemonDto){
        jdbcTemplate.update("INSERT INTO POKEMONS VALUES (?, ?, ?, ?)",
                pokemonDto.getId(), pokemonDto.getName(), pokemonDto.getWeight(), pokemonDto.getSpeciesName());
    }

    public void showAll(){
        List<PokemonDto> pokemonDtoList = this.jdbcTemplate.query(
                "select * from POKEMONS",
                new RowMapper<PokemonDto>() {
                    public PokemonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PokemonDto pokemonDto = new PokemonDto();
                        pokemonDto.setName(rs.getString("name"));
                        pokemonDto.setId(Integer.parseInt(rs.getString("id")));
                        pokemonDto.setWeight(Integer.parseInt(rs.getString("weight")));
                        pokemonDto.setSpeciesName(rs.getString("speciesName"));
                        return pokemonDto;
                    }
                });
        System.out.println("something");

    }
}