package util;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String getName() {
        return faker.name().firstName();
    }

    public static String getSurName() {
        return faker.name().lastName();
    }

    public static String getPhoneNumber() {
        return " +7 495" + faker.number().digits(7);
    }

    public static String getNumberCard() {
        return "77" + faker.number().digits(11);
    }

    public static String getEmail() {
        return faker.name().firstName() + "@mail.ru";
    }

    public static String getMessage() {
        return faker.lorem().characters(50, 100);
    }
}
