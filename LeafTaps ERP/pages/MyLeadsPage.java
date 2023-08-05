package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class MyLeadsPage extends BaseClass {
	public MyLeadsPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public CreateLeadPage clickOnCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			reportStep("Pass", "Create Lead is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Create Lead is Not Clicked Successfully" +e);
		}
		return new CreateLeadPage(driver,node);
	}
	public FindLeadsPage clickOnFindLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Pass", "Find Leads is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Find Leads is Not Clicked Successfully" +e);
		}
		return new FindLeadsPage(driver,node);
		
	}
	public MergeLeadsPage clickOnMergeLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Merge Leads")).click();
			reportStep("Pass", "Merge Leads is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Merge Leads is Not Clicked Successfully" +e);
		}
		return new MergeLeadsPage(driver,node);
	}

}
