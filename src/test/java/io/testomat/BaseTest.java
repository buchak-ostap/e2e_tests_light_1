package io.testomat;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light_1.common.Application;
import io.testomat.e2e_tests_light_1.enums.Role;
import io.testomat.e2e_tests_light_1.util.TestUser;
import io.testomat.util.CredentialsReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Configuration.*;
import static io.github.cdimascio.dotenv.Dotenv.configure;
import static java.lang.Boolean.parseBoolean;
import static java.lang.System.getProperty;
import static java.lang.System.out;

@ExtendWith({TextReportExtension.class})
public abstract class BaseTest {

    static Dotenv env = configure().ignoreIfMissing().load();
    protected static Application app = new Application();

    static {
        baseUrl = getProperty("baseUrl", env.get("BASE_URL"));
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("BASE_URL is not set in system properties or .env file");
        }
    }

    @BeforeAll
    public static void globalSetUp() {
        browser = getProperty("browser", "chrome");
        browserSize = getProperty("browserSize", "1920x1080");
        headless = parseBoolean(getProperty("headless", "false"));
        out.printf("🧪 Running tests on %s [%s] | Headless: %s | Base URL: %s%n", browser, browserSize, headless, baseUrl);
    }

    public static void loginAs(Role role) {
        TestUser user = CredentialsReader.getUser(role.getName());
        app.signInPage.open().loginUser(user);
        app.projectsPage.signInSuccess();
    }
}