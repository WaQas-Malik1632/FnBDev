package com.fnb.qa.testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.fnb.qa.pages.LoginPage;
import com.fnb.qa.base.TestBase;
import com.fnb.qa.pages.HomePageClass;

import java.io.IOException;

public class HomePageTestClass extends TestBase {

    LoginPage login;
    HomePageClass home;

    public HomePageTestClass() throws IOException {

        super();
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {

        intialization();
        login = new LoginPage();
        //	login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
        login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
        home = new HomePageClass();
    }

    @Test(priority = 1, invocationCount = 1, enabled = true, description = "Home Page Test #1", groups = {"Smoke_Suite"})
    @Description("Home Page->Verify that logged-in user is able to validate Home Page Title")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Home Page TestCases")
    @Step("Login->Home->Verify Elements")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateHomePageTitle() {

        home.ValidateHomePageTitle();
        Assert.assertTrue(true, "passed");
    }

    @Test(priority = 2, invocationCount = 1, enabled = true, description = "Home Page Test #2", groups = {"Smoke_Suite"})
    @Description("Home Page->Verify that logged-in user is able to validate Home Page Logo")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Home Page TestCases")
    @Step("Login->Home->Verify Elements")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateHomePageLogoIsVisible() throws InterruptedException {

        home.ValidateHomePageLogo();
        Assert.assertTrue(true, "passed");
    }

    @Test(priority = 3, invocationCount = 1, enabled = true, description = "Home Page Test #3", groups = {"Smoke_Suite"})
    @Description("Home Page->Verify that logged-in user is able to view Notification Icon")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Home Page TestCases")
    @Step("Login->Home->Verify Elements")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateNotificationIconIsVisible() throws InterruptedException {

        home.NotificationIcon();
        Assert.assertTrue(true, "passed");
    }

    @Test(priority = 4, invocationCount = 1, enabled = true, description = "Home Page Test #4", groups = {"Smoke_Suite"})
    @Description("Home Page->Verify that logged-in user is able to view Profile icon")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Home Page TestCases")
    @Step("Login->Home->Verify Elements")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateProfileIconIsVisible() throws InterruptedException {

        home.ProfileIcon();
        Assert.assertTrue(true, "passed");
    }

    @Test(priority = 5, invocationCount = 1, enabled = true, description = "Home Page Test #4", groups = {"Smoke_Suite"})
    @Description("Home Page->Verify that logged-in user is able to view Asset Tile and click on it")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Home Page TestCases")
    @Step("Login->Home->Verify Elements")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateAssetTileIsVisible() throws InterruptedException {

        home.Home_AssetTileClick();
        Assert.assertTrue(true, "passed");
    }

    @AfterMethod
    public void afterMethod() {

    }
}
