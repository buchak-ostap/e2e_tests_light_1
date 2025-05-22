package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light_1.enums.ProjectName;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private final SelenideElement stickyHeader = $("div.sticky-header");

    public void isLoaded(ProjectName projectName) {
        stickyHeader.$("h2").shouldHave(text(projectName.getDisplayName()));
        stickyHeader.$("#search").shouldHave(attribute("placeholder", "Search [Cmd + K]"));
        stickyHeader.$$("a.filter-tab").shouldHave(size(4));
    }
}