package com.sclea3.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
//      Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @Test
    void fillAllForms() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Golubkin");
        $("#userEmail").setValue("user@test.org");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("238957893294");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2021");
        $x("//div[contains(text(),'5')]").click();

        $("#subjectsInput").setValue("Eng").pressEnter();

        $x("//label[contains(text(),'Sports')]").click();
        $x("//label[contains(text(),'Reading')]").click();
        $x("//label[contains(text(),'Music')]").click();

        $("#uploadPicture").uploadFromClasspath("textfile.txt");
        $("#currentAddress").setValue("Moscow");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        //Asserts
        $(".table-responsive");
        assertEquals("Alexander Golubkin","Alexander Golubkin");
        assertEquals("user@test.org","user@test.org");
        assertEquals("Male","Male");
        assertEquals("238957893294","238957893294");
        assertEquals("5 December,2021","5 December,2021");
        assertEquals("English","English");
        assertEquals("Music, Sports, Reading","Music, Sports, Reading");
        assertEquals("textfile.txt","textfile.txt");
        assertEquals("Moscow","Moscow");
        assertEquals("NCR Delhi","NCR Delhi");
    }
}

