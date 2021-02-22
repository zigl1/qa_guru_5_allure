package io.qaguru.ilgiz;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTestWithSteps {
    private static final String BASE_URL = "http://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER ="#68";
    @Test
    @Owner("IlgizKN")
    @Tags({@Tag("web"), @Tag("critical")})
    @Feature("Issues")
    @Story("Searching Issue")
    @Link(url = "https://github.com", value = BASE_URL)
    @DisplayName("Search Issue by number in repository")
    public void testIssueSearchWithSteps() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        step("Open main page", () -> {
            open(BASE_URL);
        });
        step("Looking for repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Open repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open section " + ISSUES,() -> {
            $(withText(ISSUES)).click();
        });
        step("Verify that Issue with " + ISSUE_NUMBER + " exist", () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
    @Test
    @Owner("IlgizKN")
    @Tags({@Tag("web"), @Tag("critical")})
    @Feature("Issues")
    @Story("Making Issue")
    @Link(url = "https://github.com", value = BASE_URL)
    @DisplayName("Making Issue in repository")
    public void testIssueCreationWithSteps() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        step("Open main page", () -> {
            open(BASE_URL);
        });
        step("Looking for repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Open repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open section " + ISSUES,() -> {
            $(withText(ISSUES)).click();
        });
        step("Verify that Issue with " + ISSUE_NUMBER + " exist", () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
