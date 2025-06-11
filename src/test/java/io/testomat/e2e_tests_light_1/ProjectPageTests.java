package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.BaseTest;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.enums.ProjectBadge.CLASSICAL;
import static io.testomat.e2e_tests_light_1.enums.ProjectName.MANUFACTURE_LIGHT;
import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static java.util.List.of;

@ExtendWith({TextReportExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTests extends BaseTest {

    @BeforeAll
    public void setup() {
        loginAs(REGULAR);
    }

    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
    }

    @Test
    public void searchAndVerifyProjectOpeningTest() {
        final ProjectName projectName = MANUFACTURE_LIGHT;
        app.projectsPage.isLoaded();
        app.projectsPage.searchProjectWithExpectedCount(projectName, 2);
        app.projectsPage.verifyProjectTestsCount(projectName, 0);
        app.projectsPage.verifyProjectBadges(projectName, of(CLASSICAL));
        app.projectsPage.openProject(projectName);
        app.projectPage.isLoaded(projectName);
    }
}