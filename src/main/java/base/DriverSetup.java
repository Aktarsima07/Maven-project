package base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertyFilereader;

public class DriverSetup{
	
	public static WebDriver driver;
	
	public static WebDriver invokeBrowser(){
		//switch(PropertyFilereader.getpropertyvalue("browserName")){
		//case"chrome":
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
				
			options.addArguments("--start-maximized");
				
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			
		/*	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//soft wait
			
			break;
			case"firefox":
				driver=new FirefoxDriver();
			break;
			default:
			driver=new EdgeDriver();
			break;
			
		}
		*/
		return driver;
	}
}
