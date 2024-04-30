package com.fnb.qa.base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public String Url = "https://fnbdev.vteamslabs.com/login";

	public WebDriver Setup_Browser() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	//	WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();
		driver.get(Url);
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);

		return driver;
	}

	public WebDriver Setup_HeadlessBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("-incognito");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);
		driver.get(Url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebDriver SetupCrossBrowser() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n" + "Enter brower Name:");
		String browser = sc.nextLine();
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(Url);
			return driver;

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(Url);
			return driver;
		} else if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Url);
			return driver;
		} else {
			System.out.println("Invalid browser");
		}
		return driver;
		
	}

	// Take Screenshot
	public WebDriver TakeScreenshot(WebDriver webdriver, String filename) throws IOException {
		TakesScreenshot src = ((TakesScreenshot) webdriver);
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(".//Screenshot//" + filename + ".png"));
		return webdriver;
	}

}
