package com.thetestingacademy.web.testbase;

import com.thetestingacademy.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;

public class TestBase {

    @BeforeSuite
    public void init(){
        DriverManagerTL.init();
    }

    @AfterSuite
    public void tearDown(){
        DriverManagerTL.tearDown();
    }

    public void takeScreenshot(String name){
        Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)DriverManagerTL.getDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }
}
