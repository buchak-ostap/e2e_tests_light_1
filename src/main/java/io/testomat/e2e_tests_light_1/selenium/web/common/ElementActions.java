package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;

import java.time.Duration;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class ElementActions {

    private final By selector;
    private final Duration timeout;

    public ElementActions(By selector) {
        this(selector, Duration.ofSeconds(10));
    }

    public ElementActions(By selector, Duration timeout) {
        this.selector = selector;
        this.timeout = timeout;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector, this.timeout);
    }

    public Waits waitFor(Duration customTimeout) {
        return new Waits(this.selector, customTimeout);
    }
}
