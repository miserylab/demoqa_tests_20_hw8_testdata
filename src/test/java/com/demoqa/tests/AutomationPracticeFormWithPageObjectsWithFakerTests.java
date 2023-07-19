package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjectsWithFakerTests extends TestBase {

    @Test
    void fillFormTest() {
        automationPracticePage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setBirthDay(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject_1)
                .setSubject(testData.subject_2)
                .setHobbies(testData.hobby_1)
                .setHobbies(testData.hobby_2)
                .setUploadPicture(testData.picture)
                .setAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();


        automationPracticePage.modalDialogAppeared()
                .verifyModalDialogTitle("Thanks for submitting the form")
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," +  testData.birthYear)
                .verifyResult("Subjects", testData.subject_1 + ", " + testData.subject_2)
                .verifyResult("Hobbies", testData.hobby_1 + ", " + testData.hobby_2)
                .verifyResult("Picture", testData.picture)
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", testData.state + " " + testData.city);

    }

}
