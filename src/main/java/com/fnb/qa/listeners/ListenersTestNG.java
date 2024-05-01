package com.fnb.qa.listeners;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersTestNG implements ITestListener {
	public WebDriver webdriver = null;

	public void onTestSuccess(ITestResult result) {
		System.out.println("$$$$ onTestSuccess Method: " + result.getName() + " $$$$");
	}

	public void onTestFailure(ITestListener result) throws IOException {
		System.out.println("----onTestFailure Method: " + ((ITestResult) result).getName() + " ----");
		// Use this for take screenshot in the local folder
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("!!!! onTestSkipped Method: " + result.getName() + " !!!!");
	}
}