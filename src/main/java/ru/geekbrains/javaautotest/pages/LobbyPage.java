package ru.geekbrains.javaautotest.pages;

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

    public LobbyPage pressPlayNowButton() {
        buttonPlayNow.click();
        return this;
    }

    public LobbyPage pressGamesModeButton() {
        buttonGamesMode.click();
        return this;
    }

    public LobbyPage pressSimpleGamesMode() throws InterruptedException {
        choiceSimpleGamesMode.click();
        Thread.sleep(3000);
        return this;
    }

    public LobbyPage pressTimeModebutton() {
        buttonTimeMode.click();
        return this;
    }

    public LobbyPage pressRealTimeMode() throws InterruptedException {
        choiceRealTimeMode.click();
        Thread.sleep(3000);
        return this;
    }

    public LobbyPage pressLobbyModeButton() {
        buttonLobbyMode.click();
        return this;
    }

    public LobbyPage pressAutoMode() throws InterruptedException {
        choiceAutoMode.click();
        Thread.sleep(3000);
        return this;
    }

    public LobbyPage pressStartGamebutton() throws InterruptedException {
        buttonStartGame.click();
        Thread.sleep(3000);
        return this;
    }

    public LobbyPage pressUserAvatar() {
        userAvatar.click();
        return this;
    }

    public LobbyPage pressDisconnectButton() throws InterruptedException {
        buttonDisconnect.click();
        Thread.sleep(3000);
        return this;
    }

    public LobbyPage checkLoadingbar() {
        Assertions.assertTrue(loadingBar.isDisplayed());
        return this;
    }

    public LobbyPage checkEnterButton() {
        Assertions.assertTrue(enterButton.isDisplayed());
        return this;
    }
}
