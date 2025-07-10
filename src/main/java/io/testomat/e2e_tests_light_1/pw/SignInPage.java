package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.selenide.util.TestUser;

public class SignInPage {

    private final Page page;

    public SignInPage(Page page) {
        this.page = page;
    }

    public SignInPage loginUser(TestUser user) {
        page.locator("#content-desktop input#user_email").fill(user.username());
        page.locator("#content-desktop input#user_password").fill(user.password());
        page.locator("#content-desktop input#user_remember_me").click();
        page.locator("#content-desktop input[type='submit']").click();
        return this;
    }
}
