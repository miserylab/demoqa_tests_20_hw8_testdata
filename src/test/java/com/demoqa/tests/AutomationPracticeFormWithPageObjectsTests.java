package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {


    @Test
    void fillFormTest() {
        automationPracticePage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("alex@egorov.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDay("18", "July", "2003")
                .setSubject("Chemistry")
                .setSubject("Physics")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setUploadPicture("Toolsqa.jpg")
                .setAddress("Some address 1")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .clickSubmit();



        automationPracticePage.modalDialogAppeared()
                .verifyModalDialogTitle("Thanks for submitting the form")
                .verifyResult("Student Name", "Alex Egorov")
                .verifyResult("Student Email", "alex@egorov.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "0123456789")
                .verifyResult("Date of Birth", "18 July,2003")
                .verifyResult("Subjects", "Chemistry, Physics")
                .verifyResult("Hobbies", "Sports, Reading")
                .verifyResult("Picture", "Toolsqa.jpg")
                .verifyResult("Address", "Some address 1")
                .verifyResult("State and City", "Uttar Pradesh Merrut");

    }
}
