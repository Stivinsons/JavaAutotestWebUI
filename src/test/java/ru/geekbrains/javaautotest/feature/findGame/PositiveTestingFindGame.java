package ru.geekbrains.javaautotest.feature.findGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.javaautotest.base.BaseUITest;
import ru.geekbrains.javaautotest.pages.HomePage;
import static ru.geekbrains.javaautotest.common.Configuration.*;

public class PositiveTestingFindGame extends BaseUITest{

    @Test
    @DisplayName("Тестирование поиска игры")
    public void loginWithBaseUserTest() throws InterruptedException {
        new HomePage(driver)
                .pressSwitchToLoginPageButton()
                .authoriseScenario(USER_LOGIN, USER_PASSWORD)
                .pressPlayNowButton()
                .pressGamesModeButton()
                .pressSimpleGamesMode()
                .pressTimeModebutton()
                .pressRealTimeMode()
                .pressLobbyModeButton()
                .pressAutoMode()
                .pressStartGamebutton()
                .checkLoadingbar()
                .pressStartGamebutton();
    }
}
