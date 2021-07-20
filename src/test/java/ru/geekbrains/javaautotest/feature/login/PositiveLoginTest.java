package ru.geekbrains.javaautotest.feature.login;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.javaautotest.base.BaseUITest;
import ru.geekbrains.javaautotest.pages.HomePage;

import static ru.geekbrains.javaautotest.common.Configuration.*;

public class PositiveLoginTest extends BaseUITest{

    @Test
    @DisplayName("Тестирование авторизации")
    @Feature("Positive test: Login")
    public void loginWithBaseUserTest() throws InterruptedException {
        new HomePage(driver)
                .pressSwitchToLoginPageButton()
                .enterLogin(USER_LOGIN)
                .enterPassword(USER_PASSWORD)
                .notRememberMeChekbox()
                .clickLoginButton()
                .checkLoginnedUser()
                .checkUrl(HOME_PAGE_URL);

    }
}
