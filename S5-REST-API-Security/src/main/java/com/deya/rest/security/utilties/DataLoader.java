package com.deya.rest.security.utilties;

import com.deya.rest.security.entity.Book;
import com.deya.rest.security.service.BookService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        JsonNode jsonNode;
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/books.json")) {
            jsonNode = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read books.json file", e);
        }
        createBook(jsonNode);
    }

    public void createBook(JsonNode jsonNode) {
        String title = "";
        String author = "";
        String isbn = "";
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < jsonNode.size(); i++) {
            title = jsonNode.get(i).get("title").asText();
            author = jsonNode.get(i).get("author").asText();
            isbn = jsonNode.get(i).get("isbn").asText();
            books.add(new Book(title, author, isbn));
        }
        bookService.saveAll(books);
    }

}
