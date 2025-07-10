package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.enums.ProjectName;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsPage {

    private final Page page;

    public ProjectsPage(Page page) {
        this.page = page;
    }

    public ProjectsPage verifySuccessMessage() {
        assertThat(page.locator(".common-flash-success p")).hasText("Signed in successfully");
        return this;
    }

    public ProjectsPage searchProject(ProjectName project) {
        page.locator("#content-desktop #search").fill(project.getDisplayName());
        return this;
    }

    public ProjectsPage openProject(ProjectName project) {
        page.locator("a[title='" + project.getDisplayName() + "']").click();
        return this;
    }
}
