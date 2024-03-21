package TestcasePackage;

import org.testng.annotations.Test;

import PagesPackage.BaseClass;
import PagesPackage.LoginPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestClass extends BaseClass {
	private WebDriver driver;
	private LoginPage login;

	@BeforeTest
	public void initiateBrowser() {

		driver = super.Setup_Browser();
		// driver = super.SetupCrossBrowser();
		// driver=super.Setup_HeadlessBrowser();

		login = new LoginPage(driver);
	}

	@Test(priority = 1, description = "Login_TC001", enabled = true, invocationCount = 5)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("Login_EP001")
	@Feature("Login001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Testcase_VerifyLoginwith_bothWrongEmailandPassword() {
		login.Login_Testcases("Test@gmail.com ", "@1**^%$#@$_MALIK");

		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);

		// To validate whether user is successfully Registered or not
		String ExpectedUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
		}
	}

	@Test(priority = 2, description = "Login_TC002", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Testuser@gmail.com  password:Test@123")
	@Epic("EP001")
	@Feature("Login002")
	@Story("Login Test")
	@Step("Use basic steps for login")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Testcase_VerifyLoginwith_bothCorrectEmailandPassword() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		login.Login_Testcases("Testuser@gmail.com", "Test@123");
		String ExpectedUrl = "https://demo.nopcommerce.com/";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
		}
	}

	// Enter wrong Email and wrong Password
	@Test(priority = 3, description = "Login_TC003", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Login003")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void usingSession_VerifyUserDoesnotExistInSystem_SignupNewForAccount() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		login.Login_Testcases("ABCDEsFG@gmail.com", "Test@dj/%!123");
		// Assert.assertTrue(true, "Passed");

		// To verify the sessionID
		String sessionID = ((ChromeDriver) driver).getSessionId().toString();

		System.out.println("Session ID->" + sessionID);

	}

	// Enter wrong Email and wrong Password
	@Test(priority = 4, description = "Login_TC004", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Login004")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Verify_UserDoesnotExistInSystem_SignupNewForAccount() {
		// throw new SkipException("Skipped");

		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);

		login.Login_Testcases("usernewtest@gmail.com", "ZXCv@123");

		// ==== Validate user is logged in or not using Error messages====

		String actualMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		String errorMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";

		// To validate whether user is successfully Registered or not
		String ExpectedUrl = "https://demo.nopcommerce.com/";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
			try {
				super.TakeScreenshot(driver, "TestScreenshot.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
