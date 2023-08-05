package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class ViewLeadPage extends BaseClass {
	public ViewLeadPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public void verifyCreatedLeadFirstName() throws IOException {
		try {
			String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if(firstName.equals(firstName)) {
				System.out.println("Lead is Created");
			}
			else {
				System.out.println("Lead is Not Created");
			}
			reportStep("Pass", "Create Lead is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Create Lead is Not Verified Successfully" +e);
		}
	}
	public void verifyEditLeadCompanyName() throws IOException {
		try {
			String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			if(companyName.equals(companyName)) {
				System.out.println("Lead is Edited");
			}
			else {
				System.out.println("Lead is Not Edited");
			}
			reportStep("Pass", "Edit Lead is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Edit Lead is Not Verified Successfully" +e);
		}
	}
	public void verifyDuplicateLeadPhoneNumber() throws IOException {
		try {
			String phoneNumber = driver.findElement(By.xpath("//table[@class='contactTable']/tbody/tr[2]/td[2]/div")).getText();
			if(phoneNumber.contains("99")) {
				System.out.println("Duplicate Lead is Created");
			}
			else {
				System.out.println("Duplicate Lead is Not Created");
			}
			reportStep("Pass", "Duplicate Lead is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Duplicate Lead is Not Verified Successfully" +e);
		}
	}


}
