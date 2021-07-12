package ru.geekbrains.javaautotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Homework4 {

    private static WebDriver driver;
    private static final String HOME_PAGE_URL = "https://boardgamearena.com/";
    private static final String USER_LOGIN = "darara2525@nnacell.com";
    private static final String USER_PASSWORD = "qazwsxedcZSS";

    @BeforeEach
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.get(HOME_PAGE_URL);
    }

    @Test
    @DisplayName("Тестирование авторизации")
    public void testingAuth() throws InterruptedException {
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='disconnected_player_menu']"));
        enterButton.click();

        WebElement loginTextInput = driver.findElement(By.xpath("//*[@id='username_input']"));
        loginTextInput.clear();
        loginTextInput.sendKeys(USER_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.xpath("//*[@id='password_input']"));
        passwordTextInput.clear();
        passwordTextInput.sendKeys(USER_PASSWORD);

        WebElement rememberMeCheckBox = driver.findElement(By.xpath("//*[@name='rememberme']"));
        System.out.println("Before click: " + rememberMeCheckBox.isSelected());
        if (rememberMeCheckBox.isSelected()){
            rememberMeCheckBox.click();
        }
        System.out.println("After click: " + rememberMeCheckBox.isSelected());

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='submit_login_button']"));
        loginButton.click();
        Thread.sleep(3000);//ожидание необходимо для правильной обработки запроса сервером

        WebElement loginnedUser = driver.findElement(By.xpath("//*[@id='connected_user_avatar']"));
        Assertions.assertTrue(loginnedUser.isDisplayed());
        }

    @Test
    @DisplayName("Тестирование поиска игры")
    public void testFindGame() throws InterruptedException {
        testingAuth();
        WebDriverWait waitSevenSeconds = new WebDriverWait(driver, 7);
        WebElement buttonPlayNow = driver.findElement(By.xpath("//*[@id='navbutton_gamelobby']"));
        waitSevenSeconds.until(ExpectedConditions.visibilityOf(buttonPlayNow));
        buttonPlayNow.click();

        WebElement buttonGamesMode = driver.
                findElement(By.xpath("//*[@id='pageheader_mobile_switcher_wrap_gamemode']"));
        waitSevenSeconds.until(ExpectedConditions.visibilityOf(buttonGamesMode));
        buttonGamesMode.click();

        WebElement choiceSimpleGamesMode = driver.findElement(By.xpath("//*[@id='pageheader_simple']"));
        choiceSimpleGamesMode.click();

        WebElement buttonTimeMode = driver.findElement(By.xpath("//*[@id='pageheader_mobile_switcher_wrap']"));
        waitSevenSeconds.until(ExpectedConditions.visibilityOf(buttonTimeMode));
        buttonTimeMode.click();

        WebElement choiceRealTimeMode = driver.findElement(By.xpath("//*[@id='pageheader_realtime']"));
        choiceRealTimeMode.click();

        WebElement buttonLobbyMode = driver
                .findElement(By.xpath("//*[@id='pageheader_mobile_switcher_wrap_lobbymode']"));
        buttonLobbyMode.click();

        WebElement choiceAutoMode = driver.findElement(By.xpath("//*[@id='pageheader_automatic']"));
        Thread.sleep(2000);//ожидание необходимо для правильной обработки запроса сервером
        choiceAutoMode.click();

        WebElement buttonStartGame = driver.findElement(By.xpath("//*[@id='Xutton_play_1']"));
        buttonStartGame.click();
        Thread.sleep(3000);//ожидание необходимо для правильной обработки запроса сервером
        WebElement loadingBar = driver.findElement(By.xpath("//*[@id='Xannaplayauto_loadingbar_1']"));
        Assertions.assertTrue(loadingBar.isDisplayed());
        buttonStartGame.click(); //Нажать повторно для отмены поиска
        Thread.sleep(3000);//ожидание необходимо для правильной обработки запроса сервером
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Тестирование выхода из аккаунта")
    public void testingExit() throws InterruptedException {
        testingAuth();
        WebElement userAvatar = driver.findElement(By.xpath("//*[@id='connected_user_avatar']"));
        userAvatar.click();

        WebElement buttonDisconnect= driver.findElement(By.xpath("//*[@id='disconnect_button']"));
        buttonDisconnect.click();
        Thread.sleep(3000);//ожидание необходимо для правильной обработки запроса сервером
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='disconnected_player_menu']"));
        Assertions.assertTrue(enterButton.isDisplayed());
        if (driver != null) {
            driver.quit();
        }
    }
}
