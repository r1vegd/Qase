package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {
    static Faker faker = new Faker();

    public static final By CREATE_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECT_NAME_INPUT = By.xpath("//input[@id='inputTitle']");
    public static final By PROJECT_CODE_INPUT = By.xpath("//input[@id='inputCode']");
    public static final By PROJECT_DESC_INPUT = By.xpath("//textarea[@id='inputDescription']");
    public static final By MEMBER_ACCESS_PRIVATE = By.xpath("//input[@id='accessNone']");
    public static final By CREATE_NEW_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    public static final By TEST_ARTIFACTS_ABSENCE_TEXT = By.xpath("//span[@class='no-project mt-4']");

    public static final By DROPDOWN_SETTINGS = By.xpath("//a[text()='Cloud10']/ancestor::tr//i[@class='fa fa-ellipsis-h']");
    public static final By SETTINGS_OPTION = By.xpath("//a[text()='Cloud10']/ancestor::tr//a[text()='Settings']");
    public static final By SETTINGS_TITLE = By.xpath("//h1[text()='Settings']");


    public void createNewProject() {
        $(CREATE_PROJECT_BUTTON).click();
        $(PROJECT_NAME_INPUT).setValue(faker.esports().team());
        $(PROJECT_CODE_INPUT).setValue(faker.code().gtin8());
        $(PROJECT_DESC_INPUT).setValue(faker.music().genre());
        $(MEMBER_ACCESS_PRIVATE).click();
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public void openProjectSettings() {
        $(DROPDOWN_SETTINGS).click();
        $(SETTINGS_OPTION).click();
    }


}
