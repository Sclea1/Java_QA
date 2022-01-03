package com.sclea3.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HerokuDragAndDrop {

    @BeforeAll
    static void beforeAll() {
        com.codeborne.selenide.Configuration.browser = "chrome";
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Test
    void herokuTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B")).shouldBe(visible);
    }
}
