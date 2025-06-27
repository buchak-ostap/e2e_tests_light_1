package io.testomat.e2e_tests_light_1.selenide.pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ReadmePage {

    public ReadmePage clickOnEditReadme() {
        $(byText("Edit Readme")).click();
        switchTo().frame($("#modal-overlays [src='/ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage clearReadmeTextarea() {
        $(".view-lines div").click();
        actions()
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        return this;
    }

    public ReadmePage editFirstLineInEditor(String text) {
        $(".view-lines div").click();
        $("textarea").sendKeys(text);
        return this;
    }

    public void clickOnUpdate() {
        switchTo().defaultContent();
        $(byText("Update")).click();
        $(byText("Update")).shouldNotBe(visible);
    }

    public ReadmePage isLoaded() {
        $("h2").shouldHave(text("Readme"));
        return this;
    }
}
