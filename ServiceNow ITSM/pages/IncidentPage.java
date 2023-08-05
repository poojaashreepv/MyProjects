package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class IncidentPage extends BaseClass {
	Shadow shadow; //= new Shadow(driver);
	public String incidentNumber;
	public String incidentNumCheck;
	public String urgency;
	public String state;
	public String errorMsg;
	public IncidentPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public IncidentPage switchToFrame() throws IOException {//ci //uei
		try {
			shadow = new Shadow(driver);
			WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(frame1);
			reportStep("Pass", "Frame is Switched Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Frame is Not Switched Successfully" +e);
		}
		return this;
	}
	 public IncidentPage clickOnNewButton() throws IOException {//ci //cwf
		 try {
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			reportStep("Pass", "New Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "New Button is Not Clicked Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage getIncidentNumber() throws IOException {//ci 
		 try {
			incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
			 System.out.println("Incident Number is " +incidentNumber);
			 reportStep("Pass", "Incigent Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incigent Number Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage enterDescription(String descp) throws IOException {//ci
		 try {
			driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(descp,Keys.ENTER);
			reportStep("Pass", "Description is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Description is Not Entered Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage clickOnSubmitButton() throws IOException {//ci //cwf after clearCallerField
		 try {
			driver.findElement(By.xpath("(//button[@class='form_action_button  action_context btn btn-default'])[1]")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "Submit Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Submit Button is Not Clicked Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage clickOnNumberInSearchDropdown() throws IOException {//ci //ri //di
		 try {
			 WebElement search = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
			 Select searchdd=new Select(search);
			 searchdd.selectByVisibleText("Number");
			 reportStep("Pass", "Number in Search Dropdown is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Number in Search Dropdown is Not Clicked Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage enterIncidentNumberInSearchField() throws IOException {//ci //uei 
		 try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incidentNumber,Keys.ENTER);
			 // Thread.sleep(2000);
			reportStep("Pass", "Incident Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number is Not Entered Successfully" +e);
		}
	     return this;
	 }
	 public IncidentPage enterIncidentNumberInSearchField1(String incNum) throws IOException {//ri
		 try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incNum,Keys.ENTER);
			 // Thread.sleep(2000);
			reportStep("Pass", "Incident Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number is Not Entered Successfully" +e);
		}
	     return this;
	 }
	 
	 public IncidentPage enterIncidentNumberInSearchField2(String incNum1) throws IOException {//di
		 try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incNum1,Keys.ENTER);
			 // Thread.sleep(2000);
			reportStep("Pass", "Incident Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number is Not Entered Successfully" +e);
		}
	     return this;
	 }
	 public IncidentPage enterIncidentNumberInSearchField3(String incNum2) throws IOException {//ri
		 try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incNum2,Keys.ENTER);
			 // Thread.sleep(2000);
			reportStep("Pass", "Incident Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number is Not Entered Successfully" +e);
		}
	     return this;
	 }
	 public IncidentPage getFirstIncidentNumber() throws IOException {//ci //di
		 try {
			incidentNumCheck = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr[1]/td[3]")).getText();
			reportStep("Pass", "Incident Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public void verifyNewIncident() throws IOException {//ci
		 try {
			if(incidentNumber.equals(incidentNumCheck)) {
			    	System.out.println("Incident is Created ");
			    	System.out.println("Incident Number is " +incidentNumber);
			 }
			 else {
			    	System.out.println("Incident is not Created");
			 }
			reportStep("Pass", "New Incident is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "New Incident is Not Verified Successfully" +e);
		}
	 }
//	 public IncidentPage searchIncidentNumber(String incNum) {//uei //ri 
//		 driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incNum,Keys.ENTER);//"INC0010064"
//	     //Thread.sleep(2000);
//		 return this;
//	 }
	 public IncidentPage clickOnFirstIncidentNumber() throws IOException {//uei //ri
		 try {
			driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr[1]/td[3]/a")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "Incident Number is Clicked  Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Incident Number is Not clicked Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage updateUrgency() throws IOException {//uei
		 try {
			WebElement urgencyDropdown = driver.findElement(By.name("incident.urgency"));
			 Select urgencydd=new Select(urgencyDropdown);
			 urgencydd.selectByVisibleText("1 - High");
			// Thread.sleep(2000);
			 reportStep("Pass", "Urgency is Updated Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Urgency is Not Updated Successfully" +e);
		}
	     return this;
	 }
	 public IncidentPage getUrgencyText() throws IOException {//uei
		 try {
			urgency = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[1]")).getText();
			 System.out.println("The Urgency is " +urgency);
			//Thread.sleep(2000);
			 reportStep("Pass", "Urgency Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Urgency Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage updateState() throws IOException {//uei
		 try {
			WebElement stateDropdown = driver.findElement(By.name("incident.state"));
			 Select statedd=new Select(stateDropdown);
			 statedd.selectByVisibleText("In Progress");
			// Thread.sleep(2000);
			 reportStep("Pass", "State is Updated Successfully");
		} catch (Exception e) {
			reportStep("Fail", "State is Not Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage getStateText() throws IOException {//uei //ri
		 try {
			state = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[2]")).getText();
			System.out.println("The State is " +state);
			//Thread.sleep(2000);
			reportStep("Pass", "State Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "State Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage clickOnUpdateButton() throws IOException {//uei //ri
		 try {
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "Update Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Update Button is Not Clicked Successfully" +e);
		}
		 return this;
	 }
	 public void verifyPriorityState() throws IOException {//uei
		 try {
			if(urgency.contains("High")) {
				if(state.contains("In Progress")) {
					System.out.println("The Priority is Updated as High and State is Updated as In Progress");
				}
				else {
						System.out.println("The Priority is Updated as High and State is Not Updated as In Progress");
				}
				
			  }
			 else {
					System.out.println("Both Priority and State is Not Updated");
				}
			reportStep("Pass", "Incident Update is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Update is Not Verified Successfully" +e);
		}
		 
	 }
	 
	 public IncidentPage updateState1() throws IOException { //ri
		try {
			WebElement stateDropdown = driver.findElement(By.name("incident.state"));
			Select statedd=new Select(stateDropdown);
			statedd.selectByVisibleText("Resolved");
			//Thread.sleep(2000);
			reportStep("Pass", "State is Updated Successfully");
		} catch (Exception e) {
			reportStep("Fail", "State is Not Updated Successfully" +e);
		}
		return this;
	 }
//	 public IncidentPage getStateText1() {//ri
//		 String state = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[2]")).getText();
//		 System.out.println("The State is " +state);
//		 //Thread.sleep(2000);
//		 return this;
//	 }
	 public void verifyState() throws IOException { //ri
		 try {
			if(state.contains("Resolved")) {
					System.out.println("The State is Updated as Resolved");
			 }
			 else {
					System.out.println("The State is Not Updated as Resolved");
			 }
			reportStep("Pass", "Resolved Incident is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Resolved Incident is Not Verified Successfully");
		}
	 }
	 public IncidentPage getIncidentNumber1() throws IOException {//di 
		 try {
			incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
			System.out.println("Incident Number is " +incidentNumber);
			reportStep("Pass", "Incident Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Incident Number Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage clickOnDeleteButton() throws IOException {//di
		 try {
			driver.findElement(By.xpath("(//button[text()='Delete'])[2]")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "Delete Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Button is Not Clicked Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage clickOnDeleteConfirmationButton() throws IOException {//di
		 try {
			driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "Delete Confirmation Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Confirmation Button is Not Clicked Successfully" +e);
 
		}
		 return this;
	 }
	 public void verifyDeleteIncident() throws IOException {//di
		 try {
			String msg = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
			 if(msg.contains("No records to display")) {
			    System.out.println("The Incident " +incidentNumber+ " is Deleted");
			 }
			 else {
			    System.out.println("The Incident " +incidentNumber+ " is Not Deleted");
			 }
			 reportStep("Pass", "Delete Incident is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Incident is Not Verified Successfully" +e);
		}
	 }
	 public IncidentPage clearCallerField() throws IOException {//cwf
		 try {
			driver.findElement(By.xpath("(//input[@type='search'])[1]")).clear();
			 //hread.sleep(2000);
			reportStep("Pass", "Caller Field is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Caller Field is Not Cleared Successfully" +e);
		}
		 return this;
	 }
	 public IncidentPage getErrorMessageText() throws IOException {//cwf
		 try {
			errorMsg = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
			 System.out.println("The Error Message displayed is : " +errorMsg);
			 reportStep("Pass", "Error Message Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Error Message Text is Not got Successfully" +e);
		}
		 return this;
	 }
	 public void verifyErrorMessage() throws IOException {//cwf
		 try {
			if(errorMsg.contains("mandatory fields")) {
				System.out.println(errorMsg+ " : Error Message is Displayed");
			 }
			 else {
				System.out.println(errorMsg+ " : Error Message is not Displayed");
			 }
			reportStep("Pass", "Error Message is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Error Message is Not Verified Successfully" +e);
		}

	 }
	 
	 
	 
	 
	 

}
