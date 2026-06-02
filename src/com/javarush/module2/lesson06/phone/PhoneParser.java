package com.javarush.module2.lesson06.phone;

import java.util.Arrays;
import java.util.Optional;

public class PhoneParser {
    public static void main(String[] args) {
        var phones = Arrays.stream(Data.text.split("\\n"))
                .map(String::trim)
                .map(s -> s.replace(",", "."))
                .map(line -> line.split("\\s+"))
                .map(PhoneParser::getPhone)
                .filter(p->p.getFullPrice()>1000)
                .sorted((p1, p2) -> (int) p2.getFullPrice() - (int) p1.getFullPrice())
                .toArray(Phone[]::new);

        Optional<Phone> maxPricePhone = Arrays.stream(phones)
                .min((p1, p2) -> (int) p2.getFullPrice() - (int) p1.getFullPrice());

        System.out.println(maxPricePhone.orElseThrow(()->new RuntimeException("err")));

    }


    private static Phone getPhone(String[] parts) {
        return new Phone(
                parts[1],
                String.join(" ", Arrays.copyOfRange(parts, 2, parts.length - 4)),
                parts[parts.length - 4],
                parts[parts.length - 3].replaceAll("\\(\\)", ""),
                Double.parseDouble(parts[parts.length - 2]),
                Double.parseDouble(parts[parts.length - 1])
        );
    }
}
