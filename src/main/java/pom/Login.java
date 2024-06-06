package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctionsNext;

public class Login {
	WebDriver driver;
	ReusableFunctionsNext reusableFunctions;
	
	
	public Login(WebDriver driver) {
	this.driver=driver;
	this.reusableFunctions=new ReusableFunctionsNext(driver);
	
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user")
	WebElement username;
	
	@FindBy(id=("pass"))
	WebElement password;
	
	@FindBy(name="btnSubmit")
	WebElement login;
	
	public void enterUsername(String uname) { 
		reusableFunctions.setText(username, uname);
	}
	public void enterPassword(String pwd) { 
		reusableFunctions.setText(password, pwd);
	}
	public void clickLogin(){
	reusableFunctions.click(login);
	}
}