package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReusableFunctions {
	
	public static WebDriver driver;
	
	public ReusableFunctions(WebDriver driver) {
		this.driver=driver;
	}
	public static void setText(String value) {
		driver.findElement(By.id("id")).sendKeys(value);
	}
public static void click() {
	driver.findElement(By.id("id")).click();
}
public static void dropDown() {
	Select s1=new Select(driver.findElement(By.id("id")));
	 s1.selectByVisibleText("chrome");
}
}
