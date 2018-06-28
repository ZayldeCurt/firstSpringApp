package com.pokemon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppApplication {

	public static void main(String args[]) {
		SpringApplication.run(AppApplication.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

////	cześć kodu zeby wyswietlac w comand linie
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//            BookUkLibDto book = new BookUkLibDto();
//			book.setContent(restTemplate.getForObject(
////					"http://pokeapi.co/api/v2/pokemon/1", String.class); //problem strona jest https i nie obsluguje http, wiec trzeba by zrobic duze zmiany
//					"http://bnb.data.bl.uk/doc/resource/007446989.json",String.class)); //biblioteka angielska
//			log.info(book.getContent().split(",\"result")[0].replaceAll("\\{",""));
//			System.out.println(book.getContent() + "TEST");
//
//            String result ="{"+ book.getContent().split(",\"result")[0].replaceAll("\\{","")+"}";
//
//			JsonNode jsonNode = BookService.returnParsedBookContent(book);
//
//			OneBook oneBook = BookService.convertJsonToBook(result);
//		};
//	}


}