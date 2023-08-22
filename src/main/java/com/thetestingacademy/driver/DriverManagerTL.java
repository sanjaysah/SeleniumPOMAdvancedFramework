package com.thetestingacademy.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManagerTL {

    // Thread Local concept to keep static elements thread safe e.g. webdriver object (static)

    static WebDriver driver;

    public static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        tl.set(driver);
    }

    public static WebDriver getDriver(){
        return tl.get();
    }
    public static void unload(){
        tl.remove();
    }

    @BeforeMethod
    public static void init(){
        // TODO #1 add flexible code for multiple browser support
        if(getDriver()==null){
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--start-maximized");
            setDriver(new ChromeDriver(options));
        }
    }

    @AfterMethod
    public static void tearDown(){
        if(getDriver()!=null)
            getDriver().quit();
    }
}
