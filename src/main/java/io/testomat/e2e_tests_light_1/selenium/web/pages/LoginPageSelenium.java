package io.testomat.e2e_tests_light_1.selenium.web.pages;

import io.testomat.e2e_tests_light_1.selenide.util.TestUser;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;

public class LoginPageSelenium {

    public void login(TestUser user) {
        find("#content-desktop input#user_email").sendKeys(user.username());
        find("#content-desktop input#user_password").sendKeys(user.password());
        find("#content-desktop input#user_remember_me").click();
        find("#content-desktop input[type='submit']").click();
    }
}
