package com.my;
import org.apache.commons.lang3.RandomStringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {
    public static Order getRandomOrderWithBlackColour() {
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        final String lastName = RandomStringUtils.randomAlphabetic(10);
        final String address = RandomStringUtils.randomAlphabetic(15);
        final String metroStation = RandomStringUtils.randomAlphabetic(1);
        final String phone = RandomStringUtils.randomAlphabetic(11);
        final Number rentTime = (int)Math.random() * 7;
        final String deliveryDate = "2023-07-07";
        final String comment = RandomStringUtils.randomAlphabetic(10);
        final List<String> colour = new ArrayList<>();
        colour.add(new String("BLACK"));

        return new Order(firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                colour);
    }
    public static Order getRandomOrderWithGreyColour() {
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        final String lastName = RandomStringUtils.randomAlphabetic(10);
        final String address = RandomStringUtils.randomAlphabetic(15);
        final String metroStation = RandomStringUtils.randomAlphabetic(1);
        final String phone = RandomStringUtils.randomAlphabetic(11);
        final Number rentTime = (int)Math.random() * 7;
        final String deliveryDate = "2023-07-07";
        final String comment = RandomStringUtils.randomAlphabetic(10);

        final List<String> colour = new ArrayList<>();
        colour.add(new String("GREY"));

        return new Order(firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                colour);
    }
    public static Order getRandomOrderWithBlackAndGreyColour() {
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        final String lastName = RandomStringUtils.randomAlphabetic(10);
        final String address = RandomStringUtils.randomAlphabetic(15);
        final String metroStation = RandomStringUtils.randomAlphabetic(1);
        final String phone = RandomStringUtils.randomAlphabetic(11);
        final Number rentTime = (int)Math.random() * 7;
        final String deliveryDate = "2023-07-07";
        final String comment = RandomStringUtils.randomAlphabetic(10);

        final List<String> colour = new ArrayList<>();
        colour.add(new String("BLACK"));
        colour.add(new String("GREY"));

        return new Order(firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                colour);
    }
    public static Order getRandomOrderWithoutColour() {
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        final String lastName = RandomStringUtils.randomAlphabetic(10);
        final String address = RandomStringUtils.randomAlphabetic(15);
        final String metroStation = RandomStringUtils.randomAlphabetic(1);
        final String phone = RandomStringUtils.randomAlphabetic(11);
        final Number rentTime = (int)Math.random() * 7;
        final String deliveryDate = "2023-07-07";
        final String comment = RandomStringUtils.randomAlphabetic(10);

        return new Order(firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                (List<String>) null);
    }
}
