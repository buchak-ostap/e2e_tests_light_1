package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private static final String SIGN_IN_PATH = "/users/sign_in";

    private final SelenideElement contentDesktop = $("#content-desktop");
    private final SelenideElement emailInput = contentDesktop.$("input#user_email");
    private final SelenideElement passwordInput = contentDesktop.$("input#user_password");
    private final SelenideElement rememberMeCheckbox = contentDesktop.$("input#user_remember_me");
    private final SelenideElement submitButton = contentDesktop.$("input[type='submit']");

    public void open() {
        Selenide.open(SIGN_IN_PATH);
    }

    public void loginUser(String username, String password) {
        emailInput.setValue(username);
        passwordInput.setValue(password);
        rememberMeCheckbox.click();
        submitButton.click();

        // Assertion to confirm the login form disappeared
        emailInput.shouldBe(hidden);
        passwordInput.shouldBe(hidden);
    }
}