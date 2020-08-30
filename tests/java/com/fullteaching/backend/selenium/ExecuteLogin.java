package com.fullteaching.backend.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExecuteLogin {
    @FindBy(xpath = "//*[@id=\"navigation-bar\"]/div/ul/li[2]/a")
    private WebElement headerLoginButton;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement formEmail;

    @FindBy(xpath ="//*[@id=\"password\"]")
    private WebElement formPassword;

    @FindBy(xpath = "//*[@id=\"log-in-btn\"]")
    private WebElement loginButton;

    public void login(String email, String password) {
        headerLoginButton.click();
        formEmail.sendKeys(email);
        formPassword.sendKeys(password);
        loginButton.click();
    }

}
