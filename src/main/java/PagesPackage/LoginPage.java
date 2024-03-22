package PagesPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	By txt_email = By.xpath("//input[@placeholder='Email']");
	By txt_password = By.xpath("//input[@placeholder='Password']");
	By btn_Continue = By.xpath("//span[@class='indicator-label']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean Login_Testcases_Negative(String Uname, String Pass) {
		WebElement u1 = driver.findElement(txt_email);
		u1.sendKeys(Uname);

		WebElement p1 = driver.findElement(txt_password);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // page load

		WebElement b1 = driver.findElement(btn_Continue);
		b1.click();

	

		String actualUrl = driver.getCurrentUrl();
		String expectrdUrl = "https://fnbdev.vteamslabs.com/login";

		boolean cond = false;
		if (actualUrl.equalsIgnoreCase(expectrdUrl)) {
			cond = true;
		}

		else
			cond = false;

		return cond;
		
	}

	public boolean Login_Testcases(String Uname, String Pass) {
		WebElement u1 = driver.findElement(txt_email);
		u1.sendKeys(Uname);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement p1 = driver.findElement(txt_password);
		p1.sendKeys(Pass);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // page load

		WebElement b1 = driver.findElement(btn_Continue);
		b1.click();

		u1.clear();
		p1.clear();

		String actualUrl = driver.getCurrentUrl();
		String expectrdUrl = "https://fnbdev.vteamslabs.com/dashboard";

		boolean cond = false;
		if (actualUrl.equalsIgnoreCase(expectrdUrl)) {
			cond = true;
		}

		else
			cond = false;

		return cond;
	}

	public void TakeScreenshot(WebDriver webdriver, String DestFile) throws IOException {
		TakesScreenshot src = ((TakesScreenshot) webdriver);
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(srcfile, new File(".//screenshot//djkjfs.png"));
		FileUtils.copyFile(srcfile, new File(DestFile));
	}

}
