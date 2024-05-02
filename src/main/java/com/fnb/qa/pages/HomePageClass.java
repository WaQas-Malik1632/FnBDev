package com.fnb.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.fnb.qa.base.TestBase;

public class HomePageClass extends TestBase {

    By HomePageLogo = By.xpath("//*[@id=\"kt_header\"]/div/div[2]/a/img[1]");
    By Home_AssetClick = By
            .xpath(" //*[@id=\"kt_content_container\"]/section/div/div/div/div/div/div[2]/div[15]/a/div[1]/img");
    By NotificationIcon = By.xpath(
            "//body/div[@id='root']/div[@class='page d-flex flex-row flex-column-fluid pt-5']/div[@id='kt_wrapper']/div[@id='kt_header']/div[@class='container d-flex align-items-center w-100']/div[@class='d-flex align-items-stretch justify-content-between flex-lg-grow-1']/div[@class='d-flex align-items-stretch flex-shrink-0']/div[@class='d-flex align-items-stretch flex-shrink-0']/div[@class='topbar d-flex align-items-stretch flex-shrink-0']/div[3]/div[1]/img[1]");
    By ProfileIcon = By.xpath("//*[@id=\"kt_header_user_menu_toggle\"]/div[1]/img");

    public HomePageClass() throws IOException {

        super();
    }

    public void ValidateHomePageLogo() throws InterruptedException {

        Thread.sleep(3000);
        WebElement HomeLogo = driver.findElement(HomePageLogo);
        HomeLogo.isDisplayed();
    }

    public void ValidateHomePageTitle() {
        // return driver.getTitle();
        System.out.print("\n" + "Home Page Title is:" + driver.getTitle() + "\n");
    }

    public void NotificationIcon() throws InterruptedException {

        Thread.sleep(3000);
        WebElement Notify = driver.findElement(NotificationIcon);
        Notify.isDisplayed();
        Notify.click();
    }

    public void ProfileIcon() throws InterruptedException {

        Thread.sleep(3000);
        WebElement ProfileIc = driver.findElement(ProfileIcon);
        ProfileIc.isDisplayed();
        ProfileIc.click();
    }

    public void Home_AssetTileClick() throws InterruptedException {

        Thread.sleep(3000);
        WebElement AssetTile = driver.findElement(Home_AssetClick);
        AssetTile.isDisplayed();
        System.out.print("Page Url is:" + driver.getCurrentUrl()+"\n");
        
        WebElement AssetTileText=driver.findElement(By.xpath("//h6[normalize-space()='Assets']"));
      
        
        System.out.print("Asset Tile text is:" +   AssetTileText.getText() +"\n");

        String expectedUrl = "https://fnbdev.vteamslabs.com/assets";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("\n" + "->Verifying Url the Asset Page has started" + "\n");
        if (actualUrl == expectedUrl) {
            Assert.assertEquals(actualUrl, expectedUrl, "Page Url matched");
        }


        System.out.println("->Successfully clicked on Asset Tile" + "\n");
        System.out.println("User can add the asset now" + "\n");
    }

}
