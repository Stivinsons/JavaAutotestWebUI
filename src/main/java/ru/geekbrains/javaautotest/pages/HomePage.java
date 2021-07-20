package ru.geekbrains.javaautotest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.javaautotest.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='disconnected_player_menu']")
    private WebElement switchToLoginPage;

    @Step(value = "Click button switch to login page")
    public LoginPage pressSwitchToLoginPageButton() {
        switchToLoginPage.click();
        return new LoginPage(driver);
    }

    public void checkUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

}
