package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class AutomationPracticeFormWithPageObjectsWithFakerTests extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            birthDay = getRandomDay (),
            birthMonth = getRandomMonth(),
            birthYear = getRandomYear(),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            currentAddress = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state);

    @Test
    void fillFormTest() {
        automationPracticePage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobby)
                .setUploadPicture("img/Toolsqa.jpg")
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        automationPracticePage.modalDialogAppeared()
                .verifyModalDialogTitle("Thanks for submitting the form")
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," +  birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "Toolsqa.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }
}
