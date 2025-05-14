package io.testomat;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.util.CredentialsReader;
import io.testomat.util.TestUser;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    static Dotenv env = Dotenv.load();
    static String baseUrl = env.get("BASE_URL");

    @BeforeAll
    public static void globalSetUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    public static void loginAs(String role) {
        TestUser user = CredentialsReader.getUser(role);
        open(baseUrl);
        $x("//div[@id='content-desktop']//input[@id='user_email']").sendKeys(user.username());
        $x("//div[@id='content-desktop']//input[@id='user_password']").sendKeys(user.password());
        $x("//div[@id='content-desktop']//input[@id='user_remember_me']").click();
        $x("//div[@id='content-desktop']//input[@type='submit']").click();
        $x("//div[@id='content-desktop']//div[@class='common-flash-success-right']").shouldBe(visible);
    }
}