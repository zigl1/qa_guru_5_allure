package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final String BASE_URL = "http://github.com";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Looking for repository {repository} ")
    public void searchForRepository(final String REPOSITORY) {
        $(".header-search-input").setValue(REPOSITORY).submit();
    }

    @Step("Go to repository {repository}")
    public void goToRepositoryFromSearch(final String REPOSITORY) {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Open section Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Verify that Issue with {number} exist")
    public void issueWithNumberShouldExist(final String ISSUE_NUMBER) {
        $(withText(ISSUE_NUMBER)).shouldBe(visible);
    }
}