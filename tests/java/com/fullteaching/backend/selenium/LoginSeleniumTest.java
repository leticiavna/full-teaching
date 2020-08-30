package com.fullteaching.backend.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


class LoginSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "tests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // TEST CASE LV-1 ON TESTLINK
    @Test
    public void loginTest_ShouldLoginSuccessfully() throws InterruptedException {
        driver.get("http://localhost:5000/");
        Thread.sleep(3000);
        ExecuteLogin executeLogin = PageFactory.initElements(driver, ExecuteLogin.class);
        Thread.sleep(5000);
        executeLogin.login("teacher@gmail.com", "pass");
        Thread.sleep(5000);
        assertEquals("http://localhost:5000/courses", driver.getCurrentUrl());
    }


    // TEST CASE LV-3 ON TESTLINK
    @Test
    public void loginTest_ShouldGiveErrorWhenNonUserTriesToLogin() throws InterruptedException {
        driver.get("http://localhost:5000/");
        ExecuteLogin executeLogin = PageFactory.initElements(driver, ExecuteLogin.class);
        Thread.sleep(3000);
        executeLogin.login("alunum@gmail.com", "password");
        Thread.sleep(3000);

        String errorMessage = "clear\n" + // THIS LINE APPEARS IN FRONT END, IT IS THE CLOSE BUTTON (x) DESCRIPTION
                "Invalid field\n" +
                "Please check your email or password";
        WebElement errorBox = driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div[1]/div/form/app-error-message/div"));
        Thread.sleep(3000);
        assertEquals(errorMessage, errorBox.getText());
    }
}