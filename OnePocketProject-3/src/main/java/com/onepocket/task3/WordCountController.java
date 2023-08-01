package com.onepocket.task3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RestController
public class WordCountController {

    @GetMapping("/wordcount")
    public CompletableFuture<Integer> countWordsInFile() {
        return CompletableFuture.supplyAsync(this::countWords);
    }

    private int countWords() {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
