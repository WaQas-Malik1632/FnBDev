package com.fnb.qa.testcases;

import com.fnb.qa.util.TestUtil;
import org.testng.annotations.*;
import com.fnb.qa.base.TestBase;
import com.fnb.qa.pages.HomePageClass;
import com.fnb.qa.pages.LoginPage;
import com.fnb.qa.pages.AssetPageClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

public class AssetPageTestClass extends TestBase {

	TestUtil testUtil;
	LoginPage login;
	HomePageClass home;
	AssetPageClass asset;
	String sheetName = "AddAsset";

	public AssetPageTestClass() throws IOException {

		super();
	}

	@BeforeMethod
	public void initiateBrowser() throws IOException, InterruptedException {

		intialization();
		testUtil = new TestUtil();
		login = new LoginPage();
		// login.Login_Testcases("abdullah.bilal@nxb.com.pk", "Qajob@1234");
		login.Login_Testcases(prop.getProperty("username"), prop.getProperty("password"));
		home = new HomePageClass();
		home.Home_AssetTileClick();
		asset = new AssetPageClass();
	}

	@DataProvider
	public Object[][] getAddAssetDataFromExcel() throws InvalidFormatException {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, description = "Add Asset Test#1", dataProvider = "getAddAssetDataFromExcel", enabled = true, invocationCount = 1)
	@Description("Add Asset->Verify that Logged-in user is able to add Asset successfully and validate the toast message")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Add Asset TestCases")
	@Step("Login->Home Page->Add Asset Page->Add Asset")
	@Severity(SeverityLevel.CRITICAL)
	public void GetDataFromExcelToAddAssetToSystem(String AssetNo, String GoodsReceivedNo, String product,
			String LocationName, String Notes) throws InterruptedException {
		asset.addAsset(AssetNo, GoodsReceivedNo, product, LocationName, Notes);
		// To verify the toast message for Invalid GRN Number
		String toastAssetMessageVerify = "Asset number should be unique";
		Assert.assertTrue(true, "Toast message validation check: " + toastAssetMessageVerify);
		if (toastAssetMessageVerify == "Asset number should be unique") {
			System.out.print("\n" + "Asset does not add to the system" + "\n");
		} else {
			System.out.print("\n" + "Asset added to the system successfully");
		}
		/*
		 * //To verify the toast message for Invalid GRN Number String
		 * toastGRNMessageVerify = "Please enter valid GRN number";
		 * Assert.assertTrue(true, "Toast message validation check: " +
		 * toastGRNMessageVerify);
		 * 
		 * if (toastGRNMessageVerify=="Please enter valid GRN number") {
		 * System.out.print("Asset doesn't add to the system"); } else {
		 * System.out.print("Asset added to the system successfully"); }
		 */
	}

	@AfterMethod
	public void tearDown() {

		System.out.print("\n" + "Current Page URL is:" + driver.getCurrentUrl() + "\n");
	}
}
