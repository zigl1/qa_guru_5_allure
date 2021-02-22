package io.qaguru.ilgiz;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {
    private static final String repository = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER ="#68";
    @Test
    public void testIssueSearch() {


        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();

        $(withText("Issues")).click();

        $(withText(ISSUE_NUMBER)).should(Condition.exist);


    }
}
