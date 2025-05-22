package io.testomat.e2e_tests_light_1;

import io.testomat.BaseTest;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import io.testomat.e2e_tests_light_1.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pages.SignInPage;
import io.testomat.util.CredentialsReader;
import io.testomat.util.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.testomat.e2e_tests_light_1.enums.ProjectBadge.CLASSICAL;
import static io.testomat.e2e_tests_light_1.enums.ProjectName.MANUFACTURE_LIGHT;
import static java.util.List.of;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTests extends BaseTest {

    private static final SignInPage signInPage = new SignInPage();
    private static final ProjectsPage projectsPage = new ProjectsPage();
    private final ProjectPage projectPage = new ProjectPage();

    public static void loginAs(String role) {
        TestUser user = CredentialsReader.getUser(role);
        signInPage.open();
        signInPage.loginUser(user.username(), user.password());
        projectsPage.signInSuccess();
    }

    @BeforeAll
    public void setup() {
        loginAs("regular");
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
    }

    @Test
    public void searchAndVerifyProjectOpeningTest() {
        final ProjectName projectName = MANUFACTURE_LIGHT;
        projectsPage.isLoaded();
        projectsPage.searchProjectWithExpectedCount(projectName, 2);
        projectsPage.verifyProjectTestsCount(projectName, 0);
        projectsPage.verifyProjectBadges(projectName, of(CLASSICAL));
        projectsPage.openProject(projectName);
        projectPage.isLoaded(projectName);
    }


}