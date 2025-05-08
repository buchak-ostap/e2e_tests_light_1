package io.testomat.e2e_tests_light_1;

import io.testomat.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTests extends BaseTest {

    @BeforeAll
    public void setup() {
        loginAs("regular");
    }

    @Test
    public void searchAndVerifyProjectOpeningTest() {
        $x("//div[@id='content-desktop']//input[@id='search']").setValue("Manufacture light");
        $x("//div[@id='content-desktop']//a[@title='Manufacture light']").click();
        $x("//div[@class='sticky-header']//h2").shouldBe(visible, Duration.ofSeconds(3));
        $x("//div[@class='sticky-header']//h2").shouldHave(text("Manufacture light"));
    }
}
