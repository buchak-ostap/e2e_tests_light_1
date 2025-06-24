package io.testomat.e2e_tests_light_1;

import io.testomat.BaseTest;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import org.junit.jupiter.api.*;

import static io.testomat.e2e_tests_light_1.enums.ProjectBadge.CLASSICAL;
import static io.testomat.e2e_tests_light_1.enums.ProjectName.MANUFACTURE_LIGHT;
import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static java.util.List.of;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
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
    @Order(1)
    public void searchAndVerifyProjectOpeningTest() {
        final ProjectName projectName = MANUFACTURE_LIGHT;
        app.projectsPage.isLoaded()
                .searchProjectWithExpectedCount(projectName, 2)
                .verifyProjectTestsCount(projectName, 0)
                .verifyProjectBadges(projectName, of(CLASSICAL))
                .openProject(projectName);
        app.projectPage.isLoaded(projectName);
    }

    @Test()
    @Order(2)
    public void findAllProductsExperiments() {
        app.projectsPage.isLoaded()
                .verifyProjectsTestLabels(of("2 tests", "0 tests"));
    }
}