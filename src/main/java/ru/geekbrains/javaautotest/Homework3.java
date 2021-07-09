package ru.geekbrains.javaautotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Homework3 {

    private static WebDriver driver;
    private static final String HOME_PAGE_URL = "https://boardgamearena.com/";
    private static final String USER_LOGIN = "darara2525@nnacell.com";
    private static final String USER_PASSWORD = "qazwsxedcZSS";


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait waitSevenSeconds = new WebDriverWait(driver, 7);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.get(HOME_PAGE_URL);

        //Авторизация
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

        //Поиск игры
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
        choiceAutoMode.click();

        WebElement buttonStartGame = driver.findElement(By.xpath("//*[@id='Xutton_play_1']"));
        buttonStartGame.click();
        Thread.sleep(3000);//ожидание необходимо для правильной обработки запроса сервером
        buttonStartGame.click(); //Нажать повторно для отмены поиска

        //Выход из аккаунта//ожидание необходимо для правильной обработки запроса сервером
        WebElement userAvatar = driver.findElement(By.xpath("//*[@id='connected_user_avatar']"));
        userAvatar.click();

        WebElement buttonDisconnect= driver.findElement(By.xpath("//*[@id='disconnect_button']"));
        buttonDisconnect.click();

        driver.quit();

    }
}
