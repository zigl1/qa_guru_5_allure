package io.qaguru.ilgiz;

import org.junit.jupiter.api.Test;
import pages.BaseSteps;

public class MethodStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";
    public BaseSteps steps = new BaseSteps();

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.issueWithNumberShouldExist(ISSUE_NUMBER);
    }
}
