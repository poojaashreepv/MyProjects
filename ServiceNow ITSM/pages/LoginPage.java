package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public LoginPage enterUserName(String username) throws IOException {
	try {
			
		driver.findElement(By.id("user_name")).sendKeys(username);
		reportStep("Pass", "Username is Entered Successfully");
			
	} catch (Exception e) {
		reportStep("Fail", "Username is Not Entered Successfully " + e);
			
	}
	return this;
	}
	public LoginPage enterPassword(String password) throws IOException {
	try {
			
		driver.findElement(By.id("user_password")).sendKeys(password);
		reportStep("Pass", "Password is Entered Successfully");
			
	} catch (Exception e) {
		reportStep("Fail", "Password is Not Entered Successfully" + e);		
	}	
	return this;
	}
	
	public HomePage clickOnLoginButton() throws IOException {
	try {
		driver.findElement(By.id("sysverb_login")).click();
		reportStep("Pass", "Login button is Clicked Successfully");
			
	} catch (Exception e) {
		reportStep("Fail", "Login button is Not Clicked successfully " + e);
	}		
	return new HomePage(driver,node);

	}
}
