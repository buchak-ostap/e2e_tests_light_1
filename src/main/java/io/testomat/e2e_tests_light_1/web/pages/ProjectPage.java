package io.testomat.e2e_tests_light_1.web.pages;

import io.testomat.e2e_tests_light_1.enums.ProjectName;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage {

    public void isLoaded(ProjectName projectName) {
        $("h2").shouldHave(text(projectName.getDisplayName()));
        $("#search").shouldHave(attribute("placeholder", "Search [Cmd + K]"));
        $$("a.filter-tab").shouldHave(size(4));
    }

    public ProjectPage openReadme() {
        $(byLinkText("Readme")).click();
        return this;
    }

    public void clickOnEdit() {
        $(byLinkText("Edit")).click();
    }

    public ProjectPage verifyReadmeContent(String content) {
        $(".detail-view-content p").shouldHave(text(content));
        return this;
    }

    public void closeReadme() {
        $(".detail-view-actions button").click();
    }
}