package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    private static String generateDate(int months, String pattern) {
        return LocalDate.now().plusMonths(months).format(DateTimeFormatter.ofPattern(pattern));
    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getRandomCardNumber() {
        return faker.business().creditCardNumber();
    }

    public static String getUnValidCardNumber() {
        return faker.internet().password(16, 16);
    }

    public static String getValidMonths() {
        return generateDate(2, "MM");
    }

    public static String getUnValidMonths() {
        return generateDate(-2, "MM");
    }

    public static String getValidYear() {
        return generateDate(2, "yy");
    }

    public static String getUnValidYear() {
        return generateDate(-12, "yy");
    }

    public static String getValidOwnerCard() {
        return faker.name().fullName();
    }

    public static String getUnValidOwnerCard() {
        return faker.idNumber().toString();
    }

    public static String getValidCvcCode() {
        return faker.number().digits(3);
    }

    public static String getUnValidCvcCode() {
        return faker.internet().password(3, 3);
    }
}