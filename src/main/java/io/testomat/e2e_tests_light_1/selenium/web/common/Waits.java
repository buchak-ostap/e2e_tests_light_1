package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this(selector, Duration.ofSeconds(10));
    }

    public Waits(By selector, Duration timeout) {
        this.selector = selector;
        this.wait = new WebDriverWait(driver(), timeout);
        this.wait.pollingEvery(Duration.ofMillis(100));
        this.wait.ignoring(StaleElementReferenceException.class);
    }

    public Waits visibility() {
        this.wait.until(refreshed(visibilityOfElementLocated(selector)));
        return this;
    }

    public void invisibility() {
        this.wait.until(invisibilityOfElementLocated(selector));
    }

    public void hasText(String text) {
        this.wait.until(textToBe(selector, text));
    }

    public void containsText(String text) {
        this.wait.until(textMatches(
                selector, Pattern.compile(
                        Pattern.quote(text),
                        Pattern.CASE_INSENSITIVE)));
    }
}
