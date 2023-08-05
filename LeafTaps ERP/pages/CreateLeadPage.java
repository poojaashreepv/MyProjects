package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class CreateLeadPage extends BaseClass {
	
	public CreateLeadPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
    public CreateLeadPage enterCompanyName(String cname) throws IOException {
    	try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			reportStep("Pass", "Company Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Company Name is Not Entered Successfully" +e);
		}
    	return this;
	}
	public CreateLeadPage enterFirstName(String fname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			reportStep("Pass", "First Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered Successfully" +e);
		}
		return this;
	}
    public CreateLeadPage enterLastName(String lname) throws IOException {
    	try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			reportStep("Pass", "Last Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Last Name is Not Entered Successfully" +e);
		}
    	return this;
	}
    public CreateLeadPage enterPhoneNumber(String phno) {
    	try {
			try {
				driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
				reportStep("Pass", "Phone Number is Entered Successfully");
			} catch (Exception e) {
				reportStep("Fail", "Phone Number is Not Entered Successfully" +e);
			}
		} catch (Exception e) {
			
		}
    	return this;
    }
    public ViewLeadPage clickOnCreateLeadButton() throws IOException {
    	try {
			driver.findElement(By.name("submitButton")).click();
			reportStep("Pass", "Login Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Pass", "Login Button is Not Clicked Successfully" +e);
		}
    	return new ViewLeadPage(driver,node);
	}
    

}

