package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RandomUtils {
    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("GRBD = " + GET_RANDOM_BIRTHDAY);
        System.out.println("rDay = " + getRandomDay());
        System.out.println("rMonth = " + getRandomMonth());
        System.out.println("rYear = " + getRandomYear());
    }

    public static int getRandomInt(int min, int max) {
        return faker.random().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s", getRandomInt(111,  999),getRandomInt(111,  999),getRandomInt(11,  99),getRandomInt(11,  99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
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

    public static String getRandomSubject() {
        String[] subjects = {"Chemistry", "Physics", "Maths", "Commerce", "English"};
        return faker.options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
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
