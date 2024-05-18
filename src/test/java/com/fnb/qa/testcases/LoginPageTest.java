package com.fnb.qa.testcases;

import org.testng.annotations.Test;
import com.fnb.qa.base.TestBase;
import com.fnb.qa.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPageTest extends TestBase {

    LoginPage login;

    public LoginPageTest() throws IOException {

        super();
    }

    @BeforeTest
    public void setUp() throws IOException {

        intialization();
		login = new LoginPage();
    }

    // Validate that user can logged-in to the system using valid credentials
    @Test(invocationCount = 1, priority = 1, enabled = true, description = "Login Test#1", groups = {"Smoke_Suite"})
    @Description("Validate that user can logged-in using valid credentials: Email:abdullah.bilal@nxb.com.pk , password: Qajob@1234")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Login TestCases")
    @Step("Hit Site Url->Login")
    @Severity(SeverityLevel.BLOCKER)
    public void TestcaseToVerifyLoginWithBothCorrectEmailAndPassword() throws IOException {
        // ================Verify login with Take input from user====================
     /*   Scanner sc = new Scanner(System.in);
        // Type your Email address
        System.out.println("\n" + "Enter your Email:");
        String Email = sc.nextLine();
        // Type your Password
        System.out.println("\n" + "Enter your Password:");
        String Pass = sc.nextLine();
        login.Login_Testcases(Email, Pass);
*/
        //  =====================================================================
        // Verify login with passing credentials through object
        // login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
        // Verify login with passing credentials through Config.properties file
        login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
        //================Verify test with the Page Url===========================
        String ExpectedUrl = "https://fnbdev.vteamslabs.com/dashboard";
        String ActualUrl = driver.getCurrentUrl();
        System.out.println("Verifying the page url has started");
        if (actualUrl == expectedUrl) {
            Assert.assertEquals(actualUrl, expectedUrl, "Page Url matched");
        }
        System.out.println("->The page Url has been successfully verified");
        System.out.println("User logged in successfully" + "\n");

        try {
            Assert.assertEquals(ActualUrl, ExpectedUrl, "URL verification failed: ");
            System.out.println("->The page Url has been successfully verified");
            System.out.println("User logged in successfully" + "\n");
        } catch (AssertionError e) {
            System.out.println("Login Failed->These credentials do not match our records" + "\n");
            throw e; // Re-throw the assertion error to ensure the test fails
        }

        // ==================Verify test with the Page Title=======================
		/*
		  String title = "F&B System"; String actualTitle = driver.getTitle();
		  
		  System.out.println("Verifying the page title has started");
		  Assert.assertEquals(actualTitle,title,"Page title doesn't match");
		  
		  System.out.println("The page title has been successfully verified");
		  System.out.println("User logged in successfully");
		 */
    }

    @AfterTest
    public void tearDown() {
         System.out.print("\n"+driver.getCurrentUrl());
    }
}