package ru.geekbrains.javaautotest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {

    protected WebDriver driver;
    protected WebDriverWait wait10second;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.wait10second = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
