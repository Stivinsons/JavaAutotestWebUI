package ru.geekbrains.javaautotest.feature.disconnect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.javaautotest.base.BaseUITest;
import ru.geekbrains.javaautotest.pages.HomePage;

import static ru.geekbrains.javaautotest.common.Configuration.USER_LOGIN;
import static ru.geekbrains.javaautotest.common.Configuration.USER_PASSWORD;

public class PositiveDisconnect extends BaseUITest {

    @Test
    @DisplayName("Тестирование выхода из аккаунта")
    public void loginWithBaseUserTest() throws InterruptedException {
        new HomePage(driver)
                .pressSwitchToLoginPageButton()
                .authoriseScenario(USER_LOGIN, USER_PASSWORD)
                .pressUserAvatar()
                .pressDisconnectButton()
                .checkEnterButton();
    }
}
