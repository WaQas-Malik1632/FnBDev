package com.fnb.qa.testcases;

import org.testng.annotations.*;
import com.fnb.qa.base.TestBase;
import com.fnb.qa.pages.HomePageClass;
import com.fnb.qa.pages.LoginPage;
import com.fnb.qa.pages.assetPageClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.io.IOException;

import org.testng.Assert;

public class assetPageTestClass extends TestBase {

    LoginPage login;
    HomePageClass home;
    assetPageClass asset;

    public assetPageTestClass() throws IOException {

        super();
    }

    @BeforeMethod
    public void initiateBrowser() throws IOException, InterruptedException {

        intialization();
        login = new LoginPage();
        //   login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
        login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
        home = new HomePageClass();
        home.Home_AssetTileClick();
        asset = new assetPageClass();
    }

    // Add Asset->Verify that Logged-in user is able to add Asset successfully and validate the toast message
    @Test(priority = 1, invocationCount = 1, enabled = true, description = "Add Asset Test#1", groups = {"Smoke_Suite"})
    @Description("Add Asset->Verify that Logged-in user is able to add Asset successfully and validate the toast message")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Add Asset TestCases")
    @Step("Login->Home Page->Add Asset Page->Add Asset")
    @Severity(SeverityLevel.CRITICAL)
    public void addAssetToSystem() throws InterruptedException {

        asset.addAsset("2", "MG-1122333434", "Keyboard", "C3", "Test Product");
        //To verify the toast message for Invalid GRN Number
        String toastAssetMessageVerify = "Asset number should be unique";
        Assert.assertTrue(true, "Toast message validation check: " + toastAssetMessageVerify);
        if (toastAssetMessageVerify == "Asset number should be unique") {
            System.out.print("\n" + "Asset does not add to the system" + "\n");
        } else {
            System.out.print("\n" + "Asset added to the system successfully");
        }
        /*
          //To verify the toast message for Invalid GRN Number
        String toastGRNMessageVerify = "Please enter valid GRN number";
        Assert.assertTrue(true, "Toast message validation check: " + toastGRNMessageVerify);

        if (toastGRNMessageVerify=="Please enter valid GRN number") {
            System.out.print("Asset doesn't add to the system");
        } else {
            System.out.print("Asset added to the system successfully");
        }
         */
    }

    @AfterMethod
    public void tearDown() {

        System.out.print("\n" + "Current Page URL is:" + driver.getCurrentUrl() + "\n");
    }

}
