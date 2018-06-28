package com.pokemon.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.OneBook;

import java.io.IOException;

public class BookService {

    public static OneBook convertJsonToBook(String node) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
//        OneBook oneBook = new OneBook();

        OneBook oneBook1 = mapper.readValue(node, OneBook.class);

        return oneBook1;
    }

}
