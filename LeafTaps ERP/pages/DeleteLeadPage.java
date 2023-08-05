package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class DeleteLeadPage extends BaseClass {
	public String leadID;
	public DeleteLeadPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public DeleteLeadPage getLeadId() throws InterruptedException, IOException {
		
    	try {
    		Thread.sleep(2000);
			leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
			reportStep("Pass","Lead Id is got Successfully");
		} catch (Exception e) {
			reportStep("Fail","Lead Id is Not got Successfully" +e);
		}
    	return this;
    }
    public DeleteLeadPage clickOnFirstLead2() throws InterruptedException, IOException {
    	try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
			reportStep("Pass","First Lead is Clicked Successfully");
		} catch (InterruptedException e) {
			reportStep("Fail","First Lead is Not Clicked Successfully" +e);
		}
    	return this;
    }
	public DeleteLeadPage clickOnDeleteButton() throws IOException {
		try {
			driver.findElement(By.linkText("Delete")).click();
			reportStep("Pass","Delete Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Delete Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public DeleteLeadPage clickOnFindLeads3() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Pass","Find Leads is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Find Leads is Not Clicked Successfully" +e);
		}
		return this;
	}
	public DeleteLeadPage enterFirstLeadId2() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			reportStep("Pass","First Lead Id is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail","First Lead Id is Not Entered Successfully" +e);
		}
		return this;
	}
	public DeleteLeadPage clickOnFindLeads4() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Pass","Find Leads Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Find Leads Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public void verifyLeadDeletedOrNot() throws IOException {
		try {
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text not matched");
			}
			reportStep("Pass","Delete Lead is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail","Delete Lead is Not Verified Successfully" +e);
		}
		
	}

}
