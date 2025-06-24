package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light_1.enums.ProjectBadge;
import io.testomat.e2e_tests_light_1.enums.ProjectName;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.e2e_tests_light_1.enums.ProjectBadge.asLabels;
import static java.time.Duration.ofSeconds;

public class ProjectsPage {

    private static final String PROJECTS_PAGE_PATH = "/";

    private final SelenideElement contentDesktop = $("#content-desktop");
    private final SelenideElement searchInput = contentDesktop.$("#search");
    private final ElementsCollection gridItems = contentDesktop.$$("#grid li");

    public void open() {
        Selenide.open(PROJECTS_PAGE_PATH);
    }

    public void signInSuccess() {
        contentDesktop.$(".common-flash-success p").shouldBe(visible).shouldHave(text("Signed in successfully"));
    }

    public ProjectsPage isLoaded() {
        contentDesktop.$("h2").shouldHave(text("Projects"));
        searchInput.shouldHave(attribute("placeholder", "Search Project"));
        gridItems.shouldHave(sizeGreaterThan(0));
        return this;
    }

    private SelenideElement getProjectItem(ProjectName projectName) {
        return contentDesktop.$("a[title='" + projectName.getDisplayName() + "']");
    }

    public ProjectsPage searchProjectWithExpectedCount(ProjectName projectName, int expectedCount) {
        searchInput.setValue(projectName.getDisplayName());
        gridItems.filter(visible).shouldHave(size(expectedCount));
        return this;
    }

    public ProjectsPage searchProject(ProjectName projectName) {
        searchInput.setValue(projectName.getDisplayName());
        return this;
    }

    public void openProject(ProjectName projectName) {
        getProjectItem(projectName).click();
        $("div.sticky-header h2").shouldBe(visible, ofSeconds(5)).shouldHave(text(projectName.getDisplayName()));
    }

    public ProjectsPage verifyProjectTestsCount(ProjectName projectName, int expectedTestsCount) {
        getProjectItem(projectName).$("p").shouldHave(exactText(expectedTestsCount + " tests"));
        return this;
    }

    public ProjectsPage verifyProjectBadges(ProjectName projectName, List<ProjectBadge> expectedProjectBadges) {
        List<String> expectedBadgeLabels = asLabels(expectedProjectBadges);
        ElementsCollection badgeElements = getProjectItem(projectName).$$("div.project-badges span.common-badge");
        badgeElements.shouldHave(textsInAnyOrder(expectedBadgeLabels));
        return this;
    }

    public void verifyProjectsTestLabels(List<String> allowedLabels) {
        $$("ul li p")
                .shouldHave(sizeGreaterThan(0))
                .should(allMatch("Invalid test count label detected", element ->
                        allowedLabels.stream().anyMatch(label -> element.getText().contains(label))));
    }
}