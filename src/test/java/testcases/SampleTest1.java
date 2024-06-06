package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import base.ReusableFunctionsNext;

import pom.Login;
import utilities.Listenerutils;






@Listeners(Listenerutils.class)
public class SampleTest1 {
	
		  private WebDriver driver;	
		  private ReusableFunctionsNext reusableFunctions;
		  private Login login;
		  
		@BeforeTest
		public void beforetest() {
			driver=ReusableFunctionsNext.invokeBrowser(); 
			reusableFunctions=new ReusableFunctionsNext(driver);
			login=new Login(driver);		
		}
		@Test
		public void ttestcase1() {
			
		reusableFunctions.openWebsite("https://www.mycontactform.com");
		 assertEquals(driver.getCurrentUrl(),"https://www.mycontactform.com");
          assertEquals(driver.getTitle(),"Free Contact and Email Forms-myContactForm.com");	
		}
		@Test
		public void testcase2() {
			login.enterUsername("admin");
			login.enterPassword("admin");
			login.clickLogin();
			assertEquals(driver.getCurrentUrl(),"https://www.mycontactform.com");
	          assertEquals(driver.getTitle(),"Free Contact and Email Forms-myContactForm.com");	
			}
			
		
		
			
		}
		



