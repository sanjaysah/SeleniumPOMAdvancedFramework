package com.thetestingacademy.pages;

import com.thetestingacademy.base.BasePage;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage  extends BasePage {

    public LoginPage(){
        super();
    }

    // Page Locators
    @FindBy(id="login-username")
    private WebElement username;
    //private By username = By.id("login-username");

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id="js-login-btn")
    private WebElement signButton;

    @FindBy(partialLinkText = "Start a free trial")
    private WebElement sign_uplink;

    @FindBy(id="js-notification-box-msg")
    private WebElement error_message;

    private By error_message_By = By.id("js-notification-box-msg");

    public LoginPage loginToVWO(boolean valid) throws Exception {
        PageFactory.initElements(DriverManagerTL.getDriver(),this);
        implicitWait(Duration.ofSeconds(5));
        if(!valid){
            enterInput(username, PropReader.getValue("invalid_username"));
            enterInput(password,PropReader.getValue("invalid_password"));
        }
        else{
            enterInput(username, PropReader.getValue("username"));
            enterInput(password,PropReader.getValue("password"));
        }
        clickElement(signButton);
        return this;
    }

    public String failed_login_message(){
        visibilityOfElement(error_message, Duration.ofSeconds(10));
        return error_message.getText();
    }

    public DashboardPage afterLogin(){
        return new DashboardPage();
    }
}
