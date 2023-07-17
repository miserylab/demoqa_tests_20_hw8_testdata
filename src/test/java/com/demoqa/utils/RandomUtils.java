package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("GRBD = " + GET_RANDOM_BIRTHDAY);
        System.out.println("rDay = " + getRandomDay());
        System.out.println("rMonth = " + getRandomMonth());
        System.out.println("rYear = " + getRandomYear());
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    private static Date GET_RANDOM_BIRTHDAY = faker.date().birthday(16, 65);

    public static String getRandomDay () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        int dayNumber = Integer.parseInt(dateFormat.format(GET_RANDOM_BIRTHDAY));
        return String.valueOf(dayNumber);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int monthNumber = GET_RANDOM_BIRTHDAY.getMonth();
        String monthName = months[monthNumber];
        return faker.options().option(monthName);
    }

    public static String getRandomYear () {
        return String.valueOf(GET_RANDOM_BIRTHDAY.getYear() + 1900);
    }

    static List<String> subjects = new ArrayList<>(Arrays.asList("Chemistry", "Physics", "Maths", "Commerce", "English"));

    public static String getRandomSubject() {
        String subject = faker.options().option(subjects.toArray(new String[0]));
        subjects.remove(subject);
        return subject;
    }

    static List<String> hobbies = new ArrayList<>(Arrays.asList("Sports", "Reading", "Music"));

    public static String getRandomHobby() {
        String hobby = faker.options().option(hobbies.toArray(new String[0]));
        hobbies.remove(hobby);
        return hobby;
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR" -> {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(city);
            }
            case "Uttar Pradesh" -> {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(city);
            }
            case "Haryana" -> {
                String[] city = {"Karnal", "Panipat"};
                return faker.options().option(city);
            }
            case "Rajasthan" -> {
                String[] city = {"Jaipur", "Jaiselmer"};
                return faker.options().option(city);
            }
        }
        return null;
    }
}
