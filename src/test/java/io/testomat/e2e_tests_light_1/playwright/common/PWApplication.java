package io.testomat.e2e_tests_light_1.playwright.common;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.pw.HomePage;
import io.testomat.e2e_tests_light_1.pw.ProjectPage;
import io.testomat.e2e_tests_light_1.pw.ProjectsPage;
import io.testomat.e2e_tests_light_1.pw.SignInPage;

public class PWApplication {
    private final Page page;

    public final HomePage homePage;
    public final ProjectPage projectPage;
    public final ProjectsPage projectsPage;
    public final SignInPage signInPage;

    public PWApplication(Page page) {
        this.page = page;

        this.homePage = new HomePage(page);
        this.projectPage = new ProjectPage(page);
        this.projectsPage = new ProjectsPage(page);
        this.signInPage = new SignInPage(page);
    }
}
