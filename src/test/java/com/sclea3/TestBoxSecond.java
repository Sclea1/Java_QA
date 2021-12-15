package com.sclea3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestBoxSecond {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void fillAllForms() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("testemail@test.org");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("+23895789329");
        $("#dateOfBirthInput").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("Decemper");
        $(".react-datepicker__year-select").selectOption("2021");
        $x("//div[contains(text(),'5')]").click();

        $("class=css-1hwfws3").setValue("Test");

    }

}

