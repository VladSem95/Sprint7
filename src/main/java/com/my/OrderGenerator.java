package com.my;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;



public class OrderGenerator {

    private String firstColourForTest;
    private String secondColourForTest;

    public static Order getRandomOrderWithColour(String firstColourForTest,String secondColourForTest) {
        Faker faker = new Faker();
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String address = faker.address().fullAddress();
        final String metroStation = faker.address().state();
        final String phone = faker.phoneNumber().phoneNumber();
        final Number rentTime = faker.number().randomDigitNotZero();
        final String deliveryDate =faker.date().birthday().toString();
        final String comment = faker.random().toString();

        final List<String> colour = new ArrayList<>();
        colour.add(new String(firstColourForTest));
        colour.add(new String(secondColourForTest));

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
}
