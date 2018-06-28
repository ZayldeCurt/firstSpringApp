package com.pokemon.service;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.BookUkLibDto;
import com.pokemon.dto.OneBook;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class BookService {


    public JsonNode returnParsedBookContent(BookUkLibDto content) throws IOException {
        String result ="{"+ content.getContent().split(",\"result")[0].replaceAll("\\{","")+"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
//        JsonParser parser = factory.createParser(content.getContent());
        JsonParser parser = factory.createParser(result);
        JsonNode actualObj = mapper.readTree(parser);
        return actualObj;
    }

    public OneBook convertJsonToBook(String node) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        OneBook oneBook = new OneBook();

        OneBook oneBook1 = mapper.readValue(node, OneBook.class);

        return oneBook1;
    }

}
