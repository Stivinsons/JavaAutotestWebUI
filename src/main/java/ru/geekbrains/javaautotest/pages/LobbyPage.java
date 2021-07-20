package ru.geekbrains.javaautotest.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.javaautotest.base.BaseView;

public class LobbyPage extends BaseView {

    @FindBy(xpath = "//*[@id='navbutton_gamelobby']")
    private WebElement buttonPlayNow;

    @FindBy(xpath = "//*[@id='pageheader_mobile_switcher_wrap_gamemode']")
    private WebElement buttonGamesMode;

    @FindBy(xpath = "//*[@id='pageheader_simple']")
    private WebElement choiceSimpleGamesMode;

    @FindBy(xpath = "//*[@id='pageheader_mobile_switcher_wrap']")
    private WebElement buttonTimeMode;

    @FindBy(xpath = "//*[@id='pageheader_realtime']")
    private WebElement choiceRealTimeMode;

    @FindBy(xpath = "//*[@id='pageheader_mobile_switcher_wrap_lobbymode']")
    private WebElement buttonLobbyMode;

    @FindBy(xpath = "//*[@id='pageheader_automatic']")
    private WebElement choiceAutoMode;

    @FindBy(xpath = "//*[@id='Xutton_play_1']")
    private WebElement buttonStartGame;

    @FindBy(xpath = "//*[@id='Xannaplayauto_loadingbar_1']")
    private WebElement loadingBar;

    @FindBy(xpath = "//*[@id='connected_user_avatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//*[@id='disconnect_button']")
    private WebElement buttonDisconnect;

    @FindBy(xpath = "//*[@id='disconnected_player_menu']")
    private WebElement enterButton;

    public LobbyPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click play now")
    public LobbyPage pressPlayNowButton() {
        buttonPlayNow.click();
        return this;
    }

    @Step(value = "Click games mode")
    public LobbyPage pressGamesModeButton() {
        buttonGamesMode.click();
        return this;
    }

    @Step(value = "Click simple games mode")
    public LobbyPage pressSimpleGamesMode() throws InterruptedException {
        choiceSimpleGamesMode.click();
        Thread.sleep(3000);
        return this;
    }

    @Step(value = "Click time mode")
    public LobbyPage pressTimeModebutton() {
        buttonTimeMode.click();
        return this;
    }

    @Step(value = "Click real time mode")
    public LobbyPage pressRealTimeMode() throws InterruptedException {
        choiceRealTimeMode.click();
        Thread.sleep(3000);
        return this;
    }

    @Step(value = "Click lobby mode")
    public LobbyPage pressLobbyModeButton() {
        buttonLobbyMode.click();
        return this;
    }

    @Step(value = "Click auto lobby mode")
    public LobbyPage pressAutoMode() throws InterruptedException {
        choiceAutoMode.click();
        Thread.sleep(3000);
        return this;
    }

    @Step(value = "Click start game")
    public LobbyPage pressStartGamebutton() throws InterruptedException {
        buttonStartGame.click();
        Thread.sleep(3000);
        return this;
    }

    @Step(value = "Click user avatar")
    public LobbyPage pressUserAvatar() {
        userAvatar.click();
        return this;
    }

    @Step(value = "Click disconnect")
    public LobbyPage pressDisconnectButton() throws InterruptedException {
        buttonDisconnect.click();
        Thread.sleep(3000);
        return this;
    }

    @Step(value = "check loading bar")
    public LobbyPage checkLoadingbar() {
        Assertions.assertTrue(loadingBar.isDisplayed());
        return this;
    }

    @Step(value = "check enter button")
    public LobbyPage checkEnterButton() {
        Assertions.assertTrue(enterButton.isDisplayed());
        return this;
    }
}
