package io.testomat.e2e_tests_light_1.selenium.common;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.quitDriver;

public class WebDriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        driver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        quitDriver();
    }
}
