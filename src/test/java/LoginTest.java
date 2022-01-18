import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(Condition.visible);
    }
}
