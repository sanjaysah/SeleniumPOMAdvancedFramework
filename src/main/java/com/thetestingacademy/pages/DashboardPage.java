package com.thetestingacademy.pages;

import com.thetestingacademy.base.BasePage;
import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DashboardPage extends BasePage {
    public DashboardPage(){

    }

    @FindBy(css="span[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;

    public String loggedInUsername(){
        PageFactory.initElements(DriverManagerTL.getDriver(),this);
        visibilityOfElement(userNameOnDashboard, Duration.ofSeconds(10));
        return userNameOnDashboard.getText();
    }

}
