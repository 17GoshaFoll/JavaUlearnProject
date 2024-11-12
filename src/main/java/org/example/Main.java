package org.example;

import org.example.parser.CsvParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var file = "C:\\Users\\Георгий\\IdeaProjects\\JavaUlearnProject\\src\\main\\java\\org\\example\\parser\\basicprogramming_2.csv";
        var parser = CsvParser.readCSVFile(file);

    }
}

