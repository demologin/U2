package com.javarush.module1.lesson21;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RunnerCustomException {
    public static void main(String[] args) throws CustomCheckedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String pathToTxt = scanner.nextLine();
        String txt = process(pathToTxt);
        System.out.println(txt);
    }

    private static String process(String pathToTxt) throws CustomCheckedException {
        boolean empty = pathToTxt.isEmpty();
        if (empty) {
            throw new CustomCheckedException("Incorrect input (is empty)");
        }
        try (FileReader fileReader = new FileReader(pathToTxt)) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
