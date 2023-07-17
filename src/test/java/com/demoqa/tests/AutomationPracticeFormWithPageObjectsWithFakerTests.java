package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class AutomationPracticeFormWithPageObjectsWithFakerTests extends TestBase {

    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomUserEmail(),
            gender = getRandomGender(),
            userNumber = getRandomPhone(),
            birthDay = getRandomDay(),
            birthMonth = getRandomMonth(),
            birthYear = getRandomYear(),
            subject_1 = getRandomSubject(),
            subject_2 = getRandomSubject(),
            hobby_1 = getRandomHobby(),
            hobby_2 = getRandomHobby(),
            currentAddress = getRandomAddress(),
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
                .setSubject(subject_1)
                .setSubject(subject_2)
                .setHobbies(hobby_1)
                .setHobbies(hobby_2)
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
                .verifyResult("Subjects", subject_1 + ", " + subject_2)
                .verifyResult("Hobbies", hobby_1 + ", " + hobby_2)
                .verifyResult("Picture", "Toolsqa.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }
}
