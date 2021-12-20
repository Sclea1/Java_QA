package com.sclea3.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PersonalInfoTest {

    @BeforeAll
    static void config() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

        @Test
        void fillAllForms() {
            open("https://demoqa.com/text-box");
            $("#userName").setValue("Test Name");
            $("#userEmail").setValue("TestEmail@list.ru");
            $("#currentAddress").setValue("Test Address");
            $("#permanentAddress").setValue("Test Permanent Address");
            $("#submit").click();

            $("#output #name").shouldHave(text("Test Name"));
            $("#output #email").shouldHave(text("TestEmail@list.ru"));
            $("#output #currentAddress").shouldHave(text("Test Address"));
            $("#output #permanentAddress").shouldHave(text("Test Permanent Address"));
        }

    }

