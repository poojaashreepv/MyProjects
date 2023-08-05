package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class EditLeadPage1 extends BaseClass {
	public EditLeadPage1(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	    }
	    public EditLeadPage clickOnEditButton() throws IOException {
	    	try {
				driver.findElement(By.linkText("Edit")).click();
				reportStep("Pass","Edit Button is Clicked Successfully");
			} catch (Exception e) {
				reportStep("Fail","Edit Button is Not Clicked Successfully" +e);
			}
	    	return this;
		}
	    public EditLeadPage enterCompanyName(String cname) throws IOException {
	    	try {
				driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
				reportStep("Pass","Company Name is Entered Successfully");
			} catch (Exception e) {
				reportStep("Fail","Company Name is Not Entered Successfully" +e);
			}
	    	return this;
	    }
	    public ViewLeadPage clickOnUpdateButton() throws IOException { 
	    	try {
				driver.findElement(By.name("submitButton")).click();
				reportStep("Pass","Update Button is Clicked Successfully");
			} catch (Exception e) {
				reportStep("Fail","Update Button is Not Clicked Successfully" +e);
			}
	    	return new ViewLeadPage(driver,node);
	    }


}
