package io.testomat.e2e_tests_light_1.common;

import com.github.javafaker.Faker;
import io.testomat.e2e_tests_light_1.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pages.ReadmePage;
import io.testomat.e2e_tests_light_1.web.pages.SignInPage;

public class Application {

    //Pages
    public final SignInPage signInPage = new SignInPage();
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final ReadmePage readmePage = new ReadmePage();

    //Utils
    public static final Faker faker = new Faker();
}
