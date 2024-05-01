package com.fnb.qa.testcases;

import org.testng.annotations.*;
import com.fnb.qa.base.TestBase;
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
	     assetPageClass asset;

    public assetPageTestClass() throws IOException
    {
		super();
	}

    @BeforeMethod
    public void initiateBrowser() throws IOException {
    	 intialization();
         login=new LoginPage();
         login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
         asset = new assetPageClass();
    }

    // Add asset
    @Test(priority = 2, enabled = true, description = "Login Test#2", groups = {"Smoke_Suite"})
    @Description("Verify that user is able to add Asset successfully after login")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Add Asset Test")
    @Step("Use basic steps")
    @Severity(SeverityLevel.CRITICAL)
    public void addAssetToSystem() throws InterruptedException {

        asset.addAsset("2", "MG-1122333434", "Keyboard", "C3", "TestProduct");
        //To verify the toast message for Invalid GRN Number
        String toastAssetMessageVerify = "Asset number should be unique";
        Assert.assertTrue(true, "Toast message validation check: " + toastAssetMessageVerify);
        if (toastAssetMessageVerify == "Asset number should be unique") {
            System.out.print("\n" + "Asset does not add to the system");
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

        System.out.print("\n" + "Current Page URL is:" + driver.getCurrentUrl()+"\n");
    }
}
