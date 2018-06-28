package com.pokemon.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.pokemon.dto.BookUkLibDto;
import com.pokemon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class BookClientRest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BookService bookService;


    @RequestMapping("/book")//,method = RequestMethod.GET)
    public String getOurBook() throws IOException {
        BookUkLibDto book = new BookUkLibDto();
        book.setContent(restTemplate.getForObject(
                "http://bnb.data.bl.uk/doc/resource/007446989.json",String.class)); //biblioteka angielska
        JsonNode jsonNode = bookService.returnParsedBookContent(book);
        return "here will be our pokemon";
    }
}
