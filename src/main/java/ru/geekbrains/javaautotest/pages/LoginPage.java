package ru.geekbrains.javaautotest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.javaautotest.base.BaseView;

public class LoginPage extends BaseView {

    @FindBy(xpath = "//*[@id='username_input']")
    private WebElement loginTextInput;

    @FindBy(xpath = "//*[@id='password_input']")
    private WebElement passwordTextInput;

    @FindBy(xpath = "//*[@name='rememberme']")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//*[@id='submit_login_button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='connected_user_avatar']")
    private WebElement loginnedUser;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterLogin(String login) {
        loginTextInput.clear();
        loginTextInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordTextInput.clear();
        passwordTextInput.sendKeys(password);
        return this;
    }

    public LoginPage notRememberMeChekbox() {
        if (rememberMeCheckBox.isSelected()) {
            rememberMeCheckBox.click();
        }
        return this;
    }

    public HomePage checkLoginnedUser() {
        Assertions.assertTrue(loginnedUser.isDisplayed());
        return new HomePage(driver);
    }

    public LoginPage clickLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(3000);
        return this;
    }


    public LobbyPage authoriseScenario(String login, String password) throws InterruptedException {
        loginTextInput.sendKeys(login);
        passwordTextInput.sendKeys(password);
        if (rememberMeCheckBox.isSelected()) {
            rememberMeCheckBox.click();
        }
        loginButton.click();
        Thread.sleep(3000);
        return new LobbyPage(driver);
    }
}

