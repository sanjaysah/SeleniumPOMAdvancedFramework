package com.thetestingacademy.web.tests;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.DashboardPage;
import com.thetestingacademy.pages.LoginPage;
import com.thetestingacademy.utils.PropReader;
import com.thetestingacademy.utils.TestListener;
import com.thetestingacademy.web.testbase.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginTest extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the valid login expectations")
    @Test(priority = 2,groups = {"P0", "Positive"},enabled = true)
    public void testLoginVWO_Positive() throws Exception {
        DriverManagerTL.getDriver().get(PropReader.getValue("url"));
        DashboardPage dashboardPage = new LoginPage().loginToVWO(true).afterLogin();
        String expected = dashboardPage.loggedInUsername();
        Assertions.assertThat(expected).isNotNull().isNotBlank()
                .contains(PropReader.getValue("expected_username"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the invalid login expectations")
    @Test(priority = 1,groups = {"P0", "Negative"},enabled = true)
    public void testLoginVWO_Negative() throws Exception {
        DriverManagerTL.getDriver().get(PropReader.getValue("url"));
        String expectedErrorMsg = new LoginPage().loginToVWO(false).failed_login_message();
        Assertions.assertThat(expectedErrorMsg).isNotBlank().isNotNull()
                .contains(PropReader.getValue("expected_error"));
    }
}
