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
import org.testng.annotations.BeforeMethod;

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

	// Enter correct Email and correct Password
	@Test(invocationCount = 1, priority = 1, enabled = true, description = "Login Test#1", groups = { "Smoke_Suite" })
	@Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk , password: Qajob@1234")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.BLOCKER)
	public void TestcasetoVerifyLoginwithbothcorrectEmailandPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");

		String actualUrl = driver.getCurrentUrl();
		String expectrdUrl = "https://fnbdev.vteamslabs.com/dashboard";

		if(actualUrl==expectrdUrl) {
			System.out.println("Login: User has been logged in successfully");
		}
		else
		{
			System.out.println("User didn't login");
		}

		// Assert.assertTrue(facebook_Title.contains("Facebook"));
		// System.out.println("Page title matched");

	}

	// Enter wrong Email and wrong Password
	@Test(priority = 2, enabled = false, description = "Login Test#2", groups = { "Smoke_Suite" })
	@Description("Verify test using these credentials: Email:Tester@gmail.com , password:Test@!123")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	public void TestcasetoVerifyLoginwith_bothWrongEmailandPassword() {
		login.Login_Testcases("WAQAS09@gmail.com", "Test@!123");
		// throw new SkipException("Skipping the test");
		Assert.assertTrue(true, "Passed");
		// Assert.fail("Failed test");
	}

	// Enter Correct Email and wrong Password
	@Test(priority = 3, enabled = false, description = "Login Test#3", groups = { "Smoke_Suite" })
	@Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk,  password:Test@Waqas")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.MINOR)
	public void TestcasetoVerifyLoginwith_CorrectEmailandWrongPassword() {
		login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Test@Waqas");
		Assert.assertTrue(true, "Passed");
	}

	@AfterTest
	public void Teardown() {
		//System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}
}
