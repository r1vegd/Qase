package tests;

import com.codeborne.selenide.Condition;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;


public class LoginTest extends BaseTest {

    @Test(description = "User inputs login and password and authorizes on website")
    public void loginIntoSite() {
        loginPage.openTheSite();
        loginPage.login();
        $(projectsPage.CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
    }


}
