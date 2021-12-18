package com.sclea3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxSecond {

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
        $("#userNumber").setValue("+238957893294");
        $("#dateOfBirthInput").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2021");
        $x("//div[contains(text(),'5')]").click();

        $("#subjectsInput").setValue("Eng").pressEnter();

        $x("//label[contains(text(),'Sports')]").click();
        $x("//label[contains(text(),'Reading')]").click();
        $x("//label[contains(text(),'Music')]").click();

        File file = new File("src/test/resources/textfile.txt");
        Selenide.$(byId("uploadPicture")).uploadFile(file);
        $("#currentAddress").setValue("Moscow");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();
    }

    void CheckResults() {
        $(byText("Alexander Golubkin")).should(appear);
        $(byText("user@test.ru")).should(appear);
        $(byText("Male")).should(appear);
        $(byText("+238957893294")).should(appear);
        $(byText("15 December,2021")).should(appear);
        $(byText("English")).should(appear);
        $(byText("Sports, Reading, Music")).should(appear);
        $(byText("textfile.txt")).should(appear);
        $(byText("Moscow")).should(appear);
        $(byText("NCR Delhi")).should(appear);
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

}

