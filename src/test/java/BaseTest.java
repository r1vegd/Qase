import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String email, password;

    @BeforeTest
    public void setUp() {
//        Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));

        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));

        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
//        chromeOptions.addArguments("--window-size=1920,1080");
        Configuration.browserCapabilities = new ChromeOptions();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }


}
