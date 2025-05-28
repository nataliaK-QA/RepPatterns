package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private static final Random RANDOM = new Random();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String[] CITIES = {"Новосибирск", "Красноярск", "Омск", "Барнаул", "Кемерово"};

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DATE_FORMATTER);
    }

    public static String generateCity() {
        return CITIES[RANDOM.nextInt(CITIES.length)];
    }

    public static String generateName(Faker faker) {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(Faker faker) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private static final Faker faker = new Faker();

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker fakerLocalized = new Faker(new Locale(locale));
            return new UserInfo(DataGenerator.generateCity(),
                    DataGenerator.generateName(fakerLocalized),
                    DataGenerator.generatePhone(fakerLocalized));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}