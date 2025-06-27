package io.testomat.e2e_tests_light_1.selenium.common;

import io.testomat.e2e_tests_light_1.annotations.WithUserRole;
import io.testomat.e2e_tests_light_1.enums.Role;
import io.testomat.e2e_tests_light_1.selenide.util.TestUser;
import io.testomat.e2e_tests_light_1.selenium.web.pages.LoginPageSelenium;
import io.testomat.util.CredentialsReader;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class LoginTestomat implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        driver().get("https://app.testomat.io/");

        Role role = REGULAR; // default
        WithUserRole annotation = context.getRequiredTestClass().getAnnotation(WithUserRole.class);
        if (annotation != null) {
            role = annotation.value();
        }

        TestUser user = CredentialsReader.getUser(role.getName());
        new LoginPageSelenium().login(user);
    }
}
