package com.thetestingacademy.utils;

import com.thetestingacademy.driver.DriverManagerTL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestListener implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {

        File screenshot = ((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("./Screenshot/"+result.getName()+new Date().getDate()+new Date().getTime()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
