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

	// Enter correct Email and correct Password
	@Test(invocationCount = 4, priority = 1, description = "Login Test#1", groups = { "sanity_Suite","regression_Suite" })
	@Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk , password: Qajob@1234")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.BLOCKER)
	public void TestcasetoVerifyLoginwithbothcorrectEmailandPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
		Assert.assertTrue(true, "Passed");

		// Assert.assertTrue(facebook_Title.contains("Facebook"));
		// System.out.println("Page title matched");
		// System.out.println(facebook_Title);
	}

	// Enter wrong Email and wrong Password
	@Test(priority = 1, description = "Login Test#2", groups = { "sanity_Suite", "regression_Suite" }, enabled = true)
	@Description("Verify test using these credentials: Email:Tester@gmail.com , password:D_MALIK123@")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	public void TestcasetoVerifyLoginwith_bothWrongEmailandPassword() {
		login.Login_Testcases("WAQAS00999", "Test@____/%!123");
		// throw new SkipException("Skipping the test");
		Assert.assertTrue(true, "Passed");
		// Assert.fail("Failed test");
	}

	// Enter wrong Email and Password correct
	@Test(priority = 1, description = "Login Test#3", groups = { "sanity_Suite", "regression_Suite" }, enabled = true)
	@Description("Verify test using these credentials: Email:Test@gmail.com , password: TestMalik@123")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.TRIVIAL)
	public void TestcasetoVerifyLoginwith_WrongEmailandCorrectPassword() {
		login.Login_Testcases_Negative("Standard@gmail.com", "Qajob@1234");
		Assert.assertTrue(true, "Passed");
	}

	// Enter Correct Email and wrong Password
	@Test(priority = 1, description = "Login Test#4", groups = { "regression_Suite" }, enabled = true)
	@Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk,  password:sd_MALIK_Waqas")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.MINOR)
	public void TestcasetoVerifyLoginwith_CorrectEmailandWrongPassword() {
		login.Login_Testcases("abdullah.bilal@nxb.com.pk", " Test@Waqas");
		Assert.assertTrue(true, "Passed");
	}
	// Enter Correct Email and wrong Password
		@Test(priority = 1, description = "Login Test#5", groups = { "regression_Suite" }, enabled = true)
		@Description("Verify test using these credentials: Email:abdullah.bilal@nxb.com.pk")
		@Epic("EP001")
		@Feature("Feature:001")
		@Story("Login Test")
		@Step("Use basic steps")
		@Severity(SeverityLevel.MINOR)
	public void Negative_Scenario_toVerifyLoginwith_CorrectEmailOnly() {
		login.Login_Testcases_Negative("", "abdullah.bilal@nxb.com.pk");
		// Assert.fail("Failed");
		Assert.assertTrue(true, "Passed");
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
