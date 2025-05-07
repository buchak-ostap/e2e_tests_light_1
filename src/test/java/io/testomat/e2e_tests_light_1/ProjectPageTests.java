package io.testomat.e2e_tests_light_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    @Test
    public void projectPageTest() {
        open("https://app.testomat.io/");
        $x("//div[@id='content-desktop']//input[@id='user_email']").sendKeys("buchak.ostap@Gmail.com");
        $x("//div[@id='content-desktop']//input[@id='user_password']").sendKeys("Fuu4wsE2!s9e@BS");
        $x("//div[@id='content-desktop']//input[@id='user_remember_me']").click();
        $x("//div[@id='content-desktop']//input[@type='submit']").click();
        $x("//div[@id='content-desktop']//div[@class='common-flash-success-right']").shouldBe(visible);
    }
}
