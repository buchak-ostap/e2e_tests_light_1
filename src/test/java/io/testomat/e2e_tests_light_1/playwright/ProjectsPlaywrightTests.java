package io.testomat.e2e_tests_light_1.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import io.testomat.e2e_tests_light_1.playwright.common.PWApplication;
import io.testomat.e2e_tests_light_1.playwright.common.PWOptions;
import io.testomat.e2e_tests_light_1.selenide.util.TestUser;
import org.junit.jupiter.api.Test;

import static io.testomat.e2e_tests_light_1.enums.ProjectName.HOME;
import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static io.testomat.util.CredentialsReader.getUser;

@UsePlaywright(PWOptions.class)
public class ProjectsPlaywrightTests {

    @Test
    void googleSearchShouldContainPlaywright(Page page) {
        PWApplication app = new PWApplication(page);
        ProjectName project = HOME;

        //Open Page
        app.homePage
                .open();

        //Login User
        TestUser user = getUser(REGULAR.getName());
        app.signInPage
                .loginUser(user);

        //Search and Open Project
        app.projectsPage
                .verifySuccessMessage()
                .searchProject(project)
                .openProject(project);

        //Verify Project Title
        app.projectPage
                .verifyProjectTitle(project);
    }
}
