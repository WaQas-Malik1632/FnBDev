package com.fnb.qa.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.fnb.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException
	{
		super();
	}

	By txt_email = By.xpath("//input[@placeholder='Email']");
	By txt_password = By.xpath("//input[@placeholder='Password']");
	By btn_Continue = By.xpath("//span[@class='indicator-label']");

	public void Login_Testcases(String Uname, String Pass) {

		WebElement u1 = driver.findElement(txt_email);
		System.out.println("->Email field found and entering Email");
		u1.sendKeys(Uname);

		WebElement p1 = driver.findElement(txt_password);
		System.out.println("->Password field found and entering Password");
		p1.sendKeys(Pass);

		WebElement b1 = driver.findElement(btn_Continue);
		b1.click();
	}
}
