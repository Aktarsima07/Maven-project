package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctionsNext {
	private static  WebDriver driver;
	private WebDriverWait wait;
	
	public  ReusableFunctionsNext(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(20)); 
		
	}
	
	public static WebDriver invokeBrowser() {
		return driver=DriverSetup.invokeBrowser();
	}
//method to open the website
	public void openWebsite(String url) {
		driver.get(url);
	}
	//set text in any input field
	public void setText(WebElement ele, String text) {
		 waitForElementToBeVisible(ele);
		ele.clear();
		ele.sendKeys(text);
	}
	//method to click any element
	public void click(WebElement ele) {
		 waitForElementToBeVisible(ele);
		ele.click();
	}
	//method for selecting any option from a drop down 
	public void selectDropDown(WebElement ele, String text) {
		 waitForElementToBeVisible(ele);
	
			Select select=new Select(ele); 
			select.selectByVisibleText(text);
	}		
	//wait for an element to be visible on the page
	public void waitForElementToBeVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	//method to get text from any element
	//method to close the browser.
	
	public String getText(WebElement ele) {
	
	return ele.getText();	
	}
	public void closeBrowser() {
		driver.quit();
	}
	public static void takeScreenshot(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}