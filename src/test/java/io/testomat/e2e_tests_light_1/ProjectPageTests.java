package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.testomat.BaseTest;
import io.testomat.e2e_tests_light_1.enums.ProjectBadge;
import io.testomat.e2e_tests_light_1.enums.ProjectName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static io.testomat.e2e_tests_light_1.enums.ProjectBadge.CLASSICAL;
import static io.testomat.e2e_tests_light_1.enums.ProjectName.MANUFACTURE_LIGHT;
import static java.lang.Integer.parseInt;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTests extends BaseTest {

    @BeforeAll
    public void setup() {
        loginAs("regular");
    }

    @Test
    public void searchAndVerifyProjectOpeningTest() {
        final ProjectName projectName = MANUFACTURE_LIGHT;
        searchProject(projectName, 2);
        verifyProjectTestsCount(projectName, 0);
        verifyProjectBadges(projectName, of(CLASSICAL));
        openProject(projectName);
    }

    @Step
    public void searchProject(ProjectName projectName, int projectsCount) {
        $x("//div[@id='content-desktop']//input[@id='search']").setValue(projectName.getDisplayName());
        $$x("//div[@id='grid']//li").filter(visible).shouldHave(CollectionCondition.size(projectsCount));
    }

    @Step
    public void openProject(ProjectName projectName) {
        $x("//div[@id='content-desktop']//a[@title='" + projectName.getDisplayName() + "']").click();
        $x("//div[@class='sticky-header']//h2").shouldBe(visible, Duration.ofSeconds(3));
        $x("//div[@class='sticky-header']//h2").shouldHave(text(projectName.getDisplayName()));
    }

    @Step
    public void verifyProjectTestsCount(ProjectName projectName, int expectedTestsCount) {
        String actualTestsCount = $x("//div[@id='content-desktop']//a[@title='" + projectName.getDisplayName() + "']//p").getText();
        assertTrue(actualTestsCount.contains(" tests"));
        int value = parseInt(actualTestsCount.split(" ")[0]);
        assertEquals(expectedTestsCount, value, "Project tests count do not match");
    }

    @Step
    public void verifyProjectBadges(ProjectName projectName, List<ProjectBadge> expectedProjectBadges) {
        ElementsCollection actualProjectBadges = $$x("//div[@id='content-desktop']//a[@title='" + projectName.getDisplayName() + "']//div[@class='project-badges']//span[contains(@class, 'common-badge')]");
        List<String> expectedLabels = expectedProjectBadges.stream().map(ProjectBadge::getLabel).sorted().toList();
        List<String> actualLabels = actualProjectBadges.stream().map(SelenideElement::getText).sorted().toList();
        assertEquals(expectedLabels, actualLabels, "Project badges do not match");
    }
}
