package com.fullteaching.backend.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CourseSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "tests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:5000/");
        Thread.sleep(3000);
        ExecuteLogin executeLogin = PageFactory.initElements(driver, ExecuteLogin.class);
        Thread.sleep(5000);
        executeLogin.login("teacher@gmail.com", "pass");
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // TEST CASE LV-4 ON TESTLINK
    @Test
    public void courseTest_ShouldCreateCourseSuccessfully() throws InterruptedException {
        WebElement addNewCourseButton = driver.findElement(By.id("add-course-icon"));
        addNewCourseButton.click();

        Thread.sleep(3000);

        WebElement newCourseNameInput = driver.findElement(By.id("input-post-course-name"));
        newCourseNameInput.sendKeys("Novo Curso");

        WebElement saveNewCourseButton = driver.findElement(By.id("submit-post-course-btn"));
        saveNewCourseButton.click();
        Thread.sleep(5000);

        WebElement newCourseBox = driver.findElement(By.xpath("//*[@id=\"course-list\"]/li[3]/div"));
        assertTrue(newCourseBox.isDisplayed());
    }


    // TEST CASE LV-5 ON TESTLINK
    @Test
    public void courseTest_ShouldAddNewCourseSessionSuccessfully() throws InterruptedException {
        WebElement evilEyeCourseBox = driver.findElement(By.xpath("//*[@id=\"course-list\"]/li[1]/div/div[2]"));
        evilEyeCourseBox.click();
        Thread.sleep(5000);

        WebElement sessionsButton = driver.findElement(By.id("sessions-tab-icon"));
        sessionsButton.click();
        Thread.sleep(3000);

        WebElement newSessionButton = driver.findElement(By.id("add-session-icon"));
        newSessionButton.click();
        Thread.sleep(3000);

        ExecuteNewSession newSession = PageFactory.initElements(driver, ExecuteNewSession.class);
        newSession.createNewSession("Nova sessão", "Descrição da sessão", "30/09/2020", "16:00");
        Thread.sleep(3000);

        WebElement newCourseSession = driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[2]/div/ul/div[4]/li/div"));
        assertTrue(newCourseSession.getText().contains("Nova sessão\nDescrição da sessão\nSep 29, 2020 - 16:00"));
  }
}