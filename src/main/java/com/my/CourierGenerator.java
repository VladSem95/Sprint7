package com.my;
import org.apache.commons.lang3.RandomStringUtils;


public class CourierGenerator {
    public static Courier getRandom() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, firstName);
    }

    public static Courier getRandomWithoutLogin() {
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(null, password, firstName);
    }
    public static Courier getRandomWithoutPassword() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, null, firstName);
    }
    public static Courier getRandomWithoutFirstName() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, null);
    }

    public static Courier getRandomLoginCourierWithoutPassword() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, "", null);
    }

    public static Courier getRandomLoginCourierWithoutLogin() {
        final String password = RandomStringUtils.randomAlphabetic(10);
        return new Courier("", password, null);
    }
}
