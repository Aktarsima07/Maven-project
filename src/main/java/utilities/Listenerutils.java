package utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.ReusableFunctionsNext;

public class Listenerutils  implements ITestListener {
	
	
	static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void onStart(ITestContext contest) {
		try {
		extent=Extentmanager.createInstance();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	
	
	}
//creating test in extent report on start of each test
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	}
	//marking test as passed
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		test.log(Status.PASS, "Test case passed");
		String folderName=result.getInstanceName();
		String testName=result.getName();
		String filepath=System.clearProperty("user.dir")+"//TestOutput//Screenshots"+folderName+"//"+
		        testName+"//"+testName+"passed.png";
		try {
			ReusableFunctionsNext.takeScreenshot(filepath);
			test.log(Status.PASS,(Markup) test.addScreenCaptureFromPath(filepath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		test.log(Status.FAIL, "Test case Failed");
		String folderName=result.getInstanceName();
		String testName=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestOutput//Screenshots"+folderName+"//"+
																				testName+"//"+testName+"_Failed.png";
		try {
			ReusableFunctionsNext.takeScreenshot(filepath);
			test.log(Status.FAIL,(Markup) test.addScreenCaptureFromPath(filepath));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
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
	
	


