package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import io.testomat.e2e_tests_light_1.enums.ProjectName;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.testomat.e2e_tests_light_1.util.TimeUtils.toDoubleMillis;
import static java.time.Duration.ofSeconds;

public class ProjectPage {

    private final Page page;

    public ProjectPage(Page page) {
        this.page = page;
    }

    public ProjectPage verifyProjectTitle(ProjectName project) {
        assertThat(page.locator("div.sticky-header h2").first())
                .containsText(project.getDisplayName(), new LocatorAssertions.ContainsTextOptions().setTimeout(toDoubleMillis(ofSeconds(5))));
        return this;
    }
}
