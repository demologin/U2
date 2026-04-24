package com.javarush.lesson24;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NioDemo {
    public static void main(String[] args) {
//        Path workDir = Path.of(".").toAbsolutePath();
        Path src = Path.of("src");
        String[] parts = NioDemo.class.getPackageName().split("\\.");
        Path lessonDir = Path.of("src", parts);
        Path jsonFile = lessonDir.resolve("integer.json");
        String json = """
                {
                    "name": "Javarush",
                    "age": "25",
                    "height": "25"
                }
                """;
        try {
            Files.writeString(jsonFile, json, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Path path = Path.of("U2.iml");
            String txt = Files.readString(path);
            System.out.println(txt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(jsonFile)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
