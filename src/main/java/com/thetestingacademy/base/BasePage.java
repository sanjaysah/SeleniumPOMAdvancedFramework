package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{

    protected BasePage(){}

    protected void clickElement(WebElement e){
        e.click();
    }

    protected void enterInput(WebElement e, String input){
        e.sendKeys(input);
    }

    protected void implicitWait( Duration duration){
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(duration);
    }

    protected void presenceOfElement(final By by, Duration duration){
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(),duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void elementToBeClickable(final WebElement by, Duration duration){
        new WebDriverWait(DriverManagerTL.getDriver(),duration)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void visibilityOfElement(final WebElement by, Duration duration){
        new WebDriverWait(DriverManagerTL.getDriver(),duration)
                .until(ExpectedConditions.visibilityOf(by));
    }

}
