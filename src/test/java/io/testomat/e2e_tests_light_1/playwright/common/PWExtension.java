package io.testomat.e2e_tests_light_1.playwright.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PWExtension implements BeforeAllCallback, AfterAllCallback {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    public Page page() {
        return page;
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newContext().newPage();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
