package tests;

import com.codeborne.selenide.Condition;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsTest extends BaseTest {

    @Test(description = "Valid project creation")
    public void createNewProject() {
        loginPage.openTheSite();
        loginPage.login();
        projectsPage.createNewProject();
        $(projectsPage.TEST_ARTIFACTS_ABSENCE_TEXT).shouldHave(Condition.text("Looks like you don’t have any suites and cases yet."));
    }

    @Test(description = "Project settings page should be open")
    public void projectSettingsOpening() {
        loginPage.openTheSite();
        loginPage.login();
        projectsPage.openProjectSettings();
        $(projectsPage.SETTINGS_TITLE).shouldBe(Condition.visible);
    }


}
