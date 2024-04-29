package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class assetPageClass {

    private final WebDriver driver;
    By AssetClick = By.xpath("//img[@src='media/dashboard-icons/color/SVG/assets.svg']");
    By addAssetBtn = By.xpath("//a[@class='btn btn-sm btn-light-primary']");
    By assetNo = By.xpath("//input[@placeholder='Asset No.']");
    By goodsReceivedNo = By.xpath("//input[@placeholder='Enter a valid GRN number']");
    By selectProduct = By.xpath("//select[@name='product']");
    By location = By.xpath("//select[@name='location']");
    By notes = By.xpath("//input[@placeholder='write a note']");
    By submitbtn = By.xpath("//span[normalize-space()='Submit']");
    By toastValidGRNNumber = By.xpath("//div[@role='alert']");
    By toastValidAssetNo = By.xpath("//div[@role='alert']");

    public assetPageClass(WebDriver driver) {

        this.driver = driver;
    }

    public void addAsset(String AssetNo, String GoodsReceivedNo, String Notes) throws InterruptedException {

        Thread.sleep(3000);
        WebElement assetclick = driver.findElement(AssetClick);
        assetclick.click();
        Thread.sleep(3000);
        WebElement addAssetBtnclick = driver.findElement(addAssetBtn);
        addAssetBtnclick.click();
        WebElement assetNumber = driver.findElement(assetNo);
        assetNumber.sendKeys(AssetNo);
        WebElement goodsReceived = driver.findElement(goodsReceivedNo);
        goodsReceived.sendKeys(GoodsReceivedNo);
        Thread.sleep(3000);
        Select prod = new Select(driver.findElement(selectProduct));
        prod.selectByVisibleText("Laptop");
        WebElement opt = prod.getFirstSelectedOption();
        String selectedOptionProduct = opt.getText();
        System.out.println("\n" + "Selected Product: " + selectedOptionProduct);
        Thread.sleep(3000);
        Select locate = new Select(driver.findElement(location));
        locate.selectByVisibleText("C1");
        WebElement S = locate.getFirstSelectedOption();
        String selectedOptionLocation = S.getText();
        System.out.println("\n" + "Selected Location: " + selectedOptionLocation);
        Thread.sleep(3000);
        WebElement note = driver.findElement(notes);
        note.sendKeys(Notes);
        Thread.sleep(3000);
        WebElement submit = driver.findElement(submitbtn);
        submit.click();
        //Check the toast message for Invalid Asset Number
        Thread.sleep(3000);
        WebElement toastAsset = driver.findElement(toastValidAssetNo);
        String toastAssetMessage = toastAsset.getText();
        System.out.println("\n" + "Check Toast Message: " + toastAssetMessage);
/*
        //Check the toast message for Invalid GRN Number
        Thread.sleep(3000);
        WebElement toastGRN = driver.findElement(toastValidGRNNumber);
        String toastGRNMessage = toastGRN.getText();
        System.out.println("\n" + "Check Toast Message for Invalid GRN Number: " + toastGRNMessage);

 */
    }
}
