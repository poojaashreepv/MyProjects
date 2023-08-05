package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class FindLeadsPopPage extends BaseClass {
	
	public FindLeadsPopPage(ChromeDriver driver, ExtentTest node){
		this.driver = driver;
		this.node = node;
			
	}
	public FindLeadsPopPage enterFirstName(String fname) throws IOException{
		try {
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
			reportStep("Pass", "First Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered Successfully" +e);
		}
	   	 return this;
	    }
	 public FindLeadsPopPage enterFirstName1(String fname1) throws IOException {
	   	 try {
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname1);
			reportStep("Pass", "First Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered Successfully" +e);

		}
	   	 return this;
	    }
	 public FindLeadsPopPage clickOnFindLeadsButton1() throws IOException {
	   	 try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Pass", "Find Leads Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Find Leads Button is Not Clicked Successfully" +e);
		}
	   	 return this;
	   	 
	    }
	 public FindLeadsPopPage getFirstLeadIdText() throws InterruptedException, IOException {
	   	 
	   	 try {
	   		Thread.sleep(2000);
			leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
			System.out.println("Lead Id : " +leadID);
			reportStep("Pass", "First Lead Id Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Lead Id Text is Not got Successfully" +e);
		}
	   	 return this;
	    }
	 public MergeLeadsPage clickOnFirstLeadId() throws InterruptedException, IOException {
	   	 
	   	 try {
	   		Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
			switchToWindow(0);
			reportStep("Pass", "First Lead Id is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Lead Id is Not Clicked Successfully" +e);
		}
	   	return new MergeLeadsPage1(driver, node);
	    }
	 
	
}


