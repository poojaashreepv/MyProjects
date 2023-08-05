package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class MergeLeadsPage1 extends BaseClass {
	

	 public MergeLeadsPage(ChromeDriver driver,ExtentTest node) {
			this.driver=driver;
			this.node=node;
	}
    public FindLeadsPopPage cickOnFromLeadWidget() throws IOException {
   	try {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		switchToWindow(1);
		reportStep("Pass", "From Lead Widget is Clicked Successfully");
	} catch (Exception e) {
		reportStep("Fail", "From Lead Widget is Not Clicked Successfully");
	}
   	return new FindLeadsPopPage(driver, node);	
    }
    public FindLeadsPopPage cickOnToLeadWidget() throws IOException {
   	 try {
   		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		switchToWindow(1);
		reportStep("Pass", "To Lead Widget is Clicked Successfully");
	} catch (Exception e) {
		reportStep("Fail", "To Lead Widget is Not Clicked Successfully" +e);
	}
   	return new FindLeadsPopPage(driver, node);	
    }
    public MergeLeadsPage clickOnMerge() throws IOException {
   	 try {
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		reportStep("Pass", "Merge Button  is Clicked Successfully");
	} catch (Exception e) {
		reportStep("Fail", "Merge Button is Not Clicked Successfully" +e);
	}
   	 return this;
    }
    public MergeLeadsPage clickOnFindLeads3() throws IOException {
    	try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Pass", "Find Leads is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Find Leads is Not Clicked Successfully" +e);
		}
    	return this;
    }
    public MergeLeadsPage enterLeadId() throws IOException {
    	try {
    		Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			reportStep("Pass", "Lead Id is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Lead Id is Not Entered Successfully" +e);
		}
    	return this;
    }
    public MergeLeadsPage clickOnFindLeadsButton2() throws IOException {
    	try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Pass", "Find Leads Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Find Leads Button is Not Clicked Successfully" +e);
		}
    	return this;
    }
    public MergeLeadsPage verifyLeadPresentOrNot() throws IOException {
		try {
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text not matched");
			}
			reportStep("Pass", "Lead Merge is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Lead Merge is Not Verified Successfully");
		}
		return this;
    }
	
    

}
