package com.javarush.lesson23;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class CharsetDemo {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            Charset charset = entry.getValue();
            Set<String> aliases = charset.aliases();
            System.out.println(entry.getKey() + ": " + aliases);
        }
    }
}
