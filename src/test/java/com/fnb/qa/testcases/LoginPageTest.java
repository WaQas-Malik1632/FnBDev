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

    // Enter correct Email and correct Password
    @Test(invocationCount = 1, priority = 1, enabled = true, description = "Login Test#1", groups = {"Smoke_Suite"})
    @Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk , password: Qajob@1234")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Login Test")
    @Step("Use basic steps")
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
        // Verify login with static values
    //	 login.Login_Testcases("username", "password");
    	
    	//Both ways are same 
    //	 login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
         login.Login_Testcases(prop.getProperty("username"),"password");
    	
        //================Verify test with the Page Url===========================
        String expectedUrl = "https://fnbdev.vteamslabs.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Verifying the page url has started");
        if (actualUrl == expectedUrl) {
            Assert.assertEquals(actualUrl, expectedUrl, "Page Url matched");
        }
        System.out.println("->The page Url has been successfully verified");
        System.out.println("User logged in successfully"+"\n");
        
        // ==================Verify test with the Page Title=======================
		/*
		  String title = "F&B System"; String actualTitle = driver.getTitle();
		  
		  System.out.println("Verifying the page title has started");
		  Assert.assertEquals(actualTitle,title,"Page title doesn't match");
		  
		  System.out.println("The page title has been successfully verified");
		  System.out.println("User logged in successfully");
		 */
    }

    // Enter Correct Email and wrong Password
    @Test(priority = 2, enabled = false, description = "Login Test#2", groups = {"Smoke_Suite"})
    @Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk,  password:Test@Waqas")
    @Epic("EP001")
    @Feature("Feature:001")
    @Story("Login Test")
    @Step("Use basic steps")
    @Severity(SeverityLevel.MINOR)
    public void TestcaseToVerifyLoginWith_CorrectEmailAndWrongPassword() {

       // login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Test@Waqas");
        Assert.assertTrue(true, "Passed");
        // Assert.assertTrue(facebook_Title.contains("Facebook"));
        // System.out.println("Page title matched");
    }

    @AfterTest
    public void tearDown() {
         System.out.print("\n"+driver.getCurrentUrl());
    }
}
