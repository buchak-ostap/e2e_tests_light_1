package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.annotations.WithUserRole;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import io.testomat.e2e_tests_light_1.selenide.BaseTest;
import io.testomat.e2e_tests_light_1.selenium.common.LoginTestomat;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverLifeCycleExtension;
import io.testomat.e2e_tests_light_1.selenium.web.common.Waits;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static io.testomat.e2e_tests_light_1.enums.ProjectName.HOME;
import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.findByText;
import static java.time.Duration.ofSeconds;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginTestomat.class})
@WithUserRole(REGULAR)
public class ProjectPageTests extends BaseTest {

    @Test
    @Order(1)
    public void searchAndVerifyProjectOpeningTest() {
        //Wait For Success Login Message
        find(".common-flash-success p").waitFor(ofSeconds(3)).visibility().containsText("success");

        //Search Project
        ProjectName projectName = HOME;
        find("#search").sendKeys(projectName.getDisplayName());

        //Select Project
        findByText(projectName.getDisplayName()).click();

        //Wait For Page Is Loaded (testing waits)
        new Waits(By.cssSelector("div.sticky-header h2")).visibility();
        find("div.sticky-header h2").waitFor().hasText(projectName.getDisplayName());
        find("div.sticky-header h2").waitFor().containsText("home");
    }
}