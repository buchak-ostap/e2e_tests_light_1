package io.testomat;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;
import static io.github.cdimascio.dotenv.Dotenv.configure;
import static java.lang.Boolean.parseBoolean;
import static java.lang.System.getProperty;
import static java.lang.System.out;

public abstract class BaseTest {

    static Dotenv env = configure().ignoreIfMissing().load();

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
}