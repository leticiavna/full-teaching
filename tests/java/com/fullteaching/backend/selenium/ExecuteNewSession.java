package com.fullteaching.backend.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExecuteNewSession {
    @FindBy(id = "input-post-title")
    private WebElement sessionNameInput;

    @FindBy(id = "input-post-comment")
    private WebElement sessionDescriptionInput;

    @FindBy(id ="input-post-date")
    private WebElement sessionDateInput;

    @FindBy(id = "input-post-time")
    private WebElement sessionTimeInput;

    @FindBy(id = "post-modal-btn")
    private WebElement saveNewSessionButton;

    public void createNewSession(String name, String description, String date, String time) {
        sessionNameInput.sendKeys(name);
        sessionDescriptionInput.sendKeys(description);
        sessionDateInput.sendKeys(date);
        sessionTimeInput.sendKeys(time);
        saveNewSessionButton.click();
    }

}
