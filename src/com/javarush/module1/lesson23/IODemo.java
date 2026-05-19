package com.javarush.module1.lesson23;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IODemo {

    public static void main(String[] args) {
        String folderPath = getFolderPath();
        Path path = Path.of(folderPath);
        System.out.println(folderPath);
        String fileNameForIntData = folderPath + "integer.dat";
        String fileNameForTxt = folderPath + "integer.txt";
        generateBinaryFileForInts(fileNameForIntData, 25);
        List<Integer> values = readListIntFrom(fileNameForIntData);
        saveStatAndDataTo(fileNameForTxt, values);
        readTxtAndShowInConsole(fileNameForTxt);
    }

    private static String getFolderPath() {
        String root = System.getProperty("user.dir");
        String src = root + File.separator + "src" + File.separator;
        String packageName = IODemo.class.getPackageName().replace(".", File.separator);
        return src + packageName + File.separator;
    }

    private static void generateBinaryFileForInts(String fileNameForIntData, int size) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileNameForIntData)
                        )
                )
        ) {
            for (int i = 0; i < size; i++) {
                int randomInt = ThreadLocalRandom.current().nextInt(100, 400);
                dos.writeInt(randomInt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readTxtAndShowInConsole(String fileNameForTxt) {
        File file = new File(fileNameForTxt);
        Path path = file.toPath();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveStatAndDataTo(String fileNameForTxt, List<Integer> values) {
        try (PrintWriter printWriter = new PrintWriter(fileNameForTxt)) {
            int sum = 0;
            for (Integer value : values) {
                printWriter.print(value + " ");
                sum += value;
            }
            printWriter.printf("\nSum: %d Avg: %.4f", sum, ((double) sum) / values.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> readListIntFrom(String fileNameForIntData) {
        List<Integer> values = new ArrayList<>();
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileNameForIntData)
                        )
                )
        ) {
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.read();
                values.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return values;
    }
}
