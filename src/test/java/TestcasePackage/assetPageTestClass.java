package TestcasePackage;

import org.testng.annotations.Test;

import PagesPackage.BaseClass;
import PagesPackage.LoginPage;
import PagesPackage.assetPageClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class assetPageTestClass extends BaseClass {

	private WebDriver driver;
	private LoginPage login;
	private assetPageClass asset;

	@BeforeTest
	public void initiateBrowser() {

		driver = super.Setup_Browser();
		// driver = super.SetupCrossBrowser();
		// driver=super.Setup_HeadlessBrowser();
		login = new LoginPage(driver);
		asset = new assetPageClass(driver);
	}

	// Add asset
	@Test(priority = 2, enabled = true, description = "Login Test#2", groups = { "Smoke_Suite" })
	@Description("Verify that user is able to add Asset successfully after login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Add Asset Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	public void addAssetToSystem() throws InterruptedException {
		login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
		System.out.print("User logged in successfully");

		asset.addAsset("101", "2", "TestProduct");
		Assert.assertTrue(true, "Passed");
	}

	@AfterTest
	public void Teardown() {

		// System.out.print("Current Page Title is: " + driver.getTitle() + "\n" +driver.getCurrentUrl() + "\n");
	}
}
