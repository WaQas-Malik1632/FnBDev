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

	public void Login_Testcases(String Uname, String Pass) {
	
		WebElement u1 = driver.findElement(txt_email);
		System.out.println("->Email field found and entering Email");
		u1.sendKeys(Uname);
		
		driver.manage().timeouts().pageLoadTimeout(03,TimeUnit.SECONDS);
		
		WebElement p1 = driver.findElement(txt_password);
		System.out.println("->Password field found and entering Password");
		p1.sendKeys(Pass);

		driver.manage().timeouts().pageLoadTimeout(05,TimeUnit.SECONDS); // page load

		WebElement b1 = driver.findElement(btn_Continue);
		b1.click();

	}

	public void TakeScreenshot(WebDriver webdriver, String DestFile) throws IOException {
		TakesScreenshot src = ((TakesScreenshot) webdriver);
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(srcfile, new File(".//screenshot//djkjfs.png"));
		FileUtils.copyFile(srcfile, new File(DestFile));
	}

}
