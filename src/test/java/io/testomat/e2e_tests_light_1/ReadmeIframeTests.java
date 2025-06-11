package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.enums.ProjectName.MANUFACTURE_LIGHT;
import static io.testomat.e2e_tests_light_1.enums.Role.REGULAR;
import static io.testomat.util.RandomStringUtil.generate;

@ExtendWith({TextReportExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReadmeIframeTests extends BaseTest {

    @BeforeAll
    public void setup() {
        loginAs(REGULAR);
    }

    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
    }

    @Test
    public void updateReadmeIframeTest() {
        String editText = generate(10);
        app.projectsPage
                .isLoaded()
                .searchProject(MANUFACTURE_LIGHT)
                .openProject(MANUFACTURE_LIGHT);
        app.projectPage
                .openReadme().clickOnEdit();
        app.readmePage
                .isLoaded()
                .clickOnEditReadme()
                .clearReadmeTextarea()
                .editFirstLineInEditor(editText)
                .clickOnUpdate();
        app.projectPage
                .openReadme()
                .verifyReadmeContent(editText)
                .closeReadme();
    }
}
