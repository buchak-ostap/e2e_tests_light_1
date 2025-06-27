package io.testomat.e2e_tests_light_1.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light_1.selenide.util.TestUser;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private static final String SIGN_IN_PATH = "/users/sign_in";

    private final SelenideElement contentDesktop = $("#content-desktop");
    private final SelenideElement emailInput = contentDesktop.$("input#user_email");
    private final SelenideElement passwordInput = contentDesktop.$("input#user_password");
    private final SelenideElement rememberMeCheckbox = contentDesktop.$("input#user_remember_me");
    private final SelenideElement submitButton = contentDesktop.$("input[type='submit']");

    public SignInPage open() {
        Selenide.open(SIGN_IN_PATH);
        return this;
    }

    public void loginUser(TestUser user) {
        emailInput.setValue(user.username());
        passwordInput.setValue(user.password());
        rememberMeCheckbox.click();
        submitButton.click();

        // Assertion to confirm the login form disappeared
        emailInput.shouldBe(hidden);
        passwordInput.shouldBe(hidden);
    }
}