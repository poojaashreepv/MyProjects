package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class FindLeadsPage extends BaseClass {
	public String leadID;
	public FindLeadsPage1(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public FindLeadsPage clickOnPhone() throws IOException {
		try {
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			reportStep("Pass","Phone is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Phone is Not Clicked Successfully" +e);
		}
		return this;
	}
	public FindLeadsPage enterPhoneNumber(String phno) throws IOException {
		try {
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
			reportStep("Pass","Phone Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail","Phone Number is Not Entered Successfully" +e);
		}
		return this;
	}
	public FindLeadsPage clickOnFindLeadsButton() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Pass","Find Leads Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Find Leads Button is Not Clicked Successfully");
		}
		return this;
	}
    	public EditLeadPage clickOnFirstLead() throws InterruptedException, IOException {
    		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
			reportStep("Pass","First Lead is Clicked Successfully");
		} 
		catch (InterruptedException e) {
			reportStep("Fail","First Lead is Not Clicked Successfully" +e);
		}
    		return new EditLeadPage(driver,node);
	}
    	public DuplicateLeadPage clickOnFirstLead1() throws InterruptedException, IOException {
    		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
			reportStep("Pass","First Lead is Clicked Successfully");
		} 
		catch (InterruptedException e) {
			reportStep("Fail","First Lead is Not Clicked Successfully" +e);
		}
    		return new DuplicateLeadPage(driver,node);
	}
    	public DeleteLeadPage clickOnFindLeads() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Pass","Find Leads is Clicked Successfully");
		} 
		catch (Exception e) {
			reportStep("Fail","Find Leads is Not Clicked Successfully" +e);
		}
		return new DeleteLeadPage(driver,node);
	}

}
