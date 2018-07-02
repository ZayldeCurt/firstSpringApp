package com.pokemon.integration;

import com.pokemon.dto.PokemonDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldGetResponseBody() {
		PokemonDto body = this.testRestTemplate.getForObject("/pokemon/1",PokemonDto.class);
		assertThat(body.getName()).isEqualTo("bulbasaur");
	}

	@Test
	public void shouldGetStatusOk() {
		ResponseEntity<PokemonDto> response
				= testRestTemplate.getForEntity("/pokemon/1", PokemonDto.class);

		assertThat(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void shouldGetStatusOk4xx() {
		ResponseEntity<PokemonDto> response
				= testRestTemplate.getForEntity("/pokemon", PokemonDto.class);
		Assert.assertEquals(response.getStatusCode().value(),404);
	}

	@Test
	public void shouldGetStatusOk5xx() {
		ResponseEntity<PokemonDto> response
				= testRestTemplate.getForEntity("/pokemon/0", PokemonDto.class);
		assertThat(response.getStatusCode().is5xxServerError());
	}

}