package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.AutomationPracticePage;
import org.junit.jupiter.api.BeforeAll;





public class TestBase {
    AutomationPracticePage automationPracticePage = new AutomationPracticePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

}
