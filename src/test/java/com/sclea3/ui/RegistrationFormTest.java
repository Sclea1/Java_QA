package com.sclea3.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Test
    void fillAllForms() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Golubkin");
        $("#userEmail").setValue("user@test.org");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("2389578932");

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
        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition
                .exactTexts("Alexander Golubkin", "user@test.org", "Male", "2389578932",
                        "05 December,2021", "English", "Sports, Reading, Music", "textfile.txt",
                        "Moscow", "NCR Delhi"));
    }
}

