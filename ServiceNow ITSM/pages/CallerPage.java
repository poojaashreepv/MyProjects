package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class CallerPage extends BaseClass {
	Shadow shadow = new Shadow(driver);
	public String firstName;
	public String lastName;
	public String title;
	public String email;
	public String businessPhone;
	public String mobilePhone;
	public String modifiedBusinessPhone;
	public String businessPhone1;
	public CallerPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public CallerPage switchToFrame() throws IOException {//cnc //uec //dec
		try {
			WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(frame1);
			reportStep("Pass", "Frame is Switched Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Frame is Not Switched Successfully" +e);		
		}
		return this;
	}
	public CallerPage clickOnNewButton() throws IOException {//cnc
		try {
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			reportStep("Pass", "New Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "New Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage enterFirstName(String fname) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(fname,Keys.ENTER);
			reportStep("Pass", "First Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage enterLastName(String lname) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(lname,Keys.ENTER);
			reportStep("Pass", "Last Name is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Last Name is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage enterTitle(String title) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Title is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Title is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage enterEmail(String email) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(email,Keys.ENTER);
			reportStep("Pass", "Email is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Email is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage ebterBusinessPhone(String bphoneno) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(bphoneno,Keys.ENTER);
			reportStep("Pass", "Business Phone is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage enterMobilePhone(String mphoneno) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(mphoneno,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Mobile Phone is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Mobile Phone is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOnSubmitButton() throws IOException {//cnc
		try {
			driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "Submit Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Submit Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage enterFirstNameOnSearchField(String fname1) throws IOException {//cnc
		try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(fname1,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "First Name is Entered On Search Field Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name  Not Entered On Search Field Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOnFirstName() throws IOException {//cnc
		try {
			driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "First Name is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage getFirstNameText() throws IOException {//cnc
		try {
			firstName = driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).getAttribute("value");
			System.out.println("First Name is " +firstName);
			reportStep("Pass", "First Name Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name Text is Not got Successfully" +e);
		}
	    return this;
	}
	public CallerPage getLastNameText() throws IOException {//cnc
		try {
			lastName = driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).getAttribute("value");
			System.out.println("Last Name is " +lastName);
			reportStep("Pass", "Last Name Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Last Name Text is Not got Successfully" +e);
		}
	    return this;
	}
	public CallerPage getTitleText() throws IOException {//cnc
		try {
			title = driver.findElement(By.xpath("//input[@id='sys_user.title']")).getAttribute("value");
			System.out.println("Title is " +title);
			reportStep("Pass", "Title Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Title Text is Not got Successfully" +e);
		}
	    return this;
	}
	public CallerPage getEmailText() throws IOException {//cnc
		try {
			email = driver.findElement(By.xpath("//input[@id='sys_user.email']")).getAttribute("value");
			System.out.println("Email is " +email);
			reportStep("Pass", "Email Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Email Text is Not got Successfully" +e);
		}
	    return this;
	}
	public CallerPage getBusinessPhoneText() throws IOException {//cnc
		try {
			businessPhone = driver.findElement(By.xpath("//input[@id='sys_user.phone']")).getAttribute("value");
			System.out.println("Business Phone is " +businessPhone);
			reportStep("Pass", "Business Phone Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone Text is Not got Successfully" +e);
		}
	    return this;
	}
	public CallerPage getMobilePhoneText() throws IOException {//cnc
		try {
			mobilePhone = driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).getAttribute("value");
			System.out.println("Mobile Phone is " +mobilePhone);
			//Thread.sleep(2000);
			reportStep("Pass", "Mobile Phone Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Mobile Phone Text is Not got Successfully" +e);
		}
	    return this;
	}
	public void verifyCallerCreation() throws IOException {//cnc
		 try {
			if((firstName.contains("Poojaashree") )&& (lastName.contains("P V")) && (title.contains("ServiceNow")) && (email.contains("poojaashree250@example.com")) && (businessPhone.contains("123456789")) && (mobilePhone.contains("1234567890"))) {
				 System.out.println("New Caller is Created ");
			 }
			 else {
				 System.out.println("New Caller is Not Created");
			 }
			reportStep("Pass", "Create Caller is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Create Caller is Not Verified Successfully" +e);
		}
	}
	public CallerPage enterFirstNameOnSearchField1(String fname2) throws IOException {//uec //dec
		 try {
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(fname2,Keys.ENTER);
			reportStep("Pass", "First Name is Entered On Search Field Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered On Search Field Successfully" +e);
		}		
		 return this;
	}
	public CallerPage clickOnFirstName1() throws IOException {//uec //dec
		try {
			driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).click();
			reportStep("Pass", "First Name is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage clearBusinessPhone() throws IOException {//uec
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.phone']")).clear();
			reportStep("Pass", "Business Phone is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone is Not Cleared Successfully" +e);
		}
		return this;
	}
	public CallerPage enterBusinessPhone(String bphoneno1) throws IOException {//uec
		try {
			driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(bphoneno1,Keys.ENTER);
			//Thread.sleep(1000);
			reportStep("Pass", "Business Phone is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone is Not Entered Successfully" +e);
		}
		return this;
	}
	public CallerPage getBusinessPhoneText1() throws IOException {//uec
		try {
			modifiedBusinessPhone = driver.findElement(By.xpath("//input[@id='sys_user.phone']")).getAttribute("value");
			System.out.println("Modified Business Phone Number is " +modifiedBusinessPhone);
			reportStep("Pass", "Business Phone Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone Text is Not got Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOnUpdateButton() throws IOException {//uec
		try {
			driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[1]")).click();
			reportStep("Pass", "Update Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Update Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOnFirstNameDisplayedInTable() throws IOException {//uec
		try {
			driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).click();
			reportStep("Pass", "First Name Displayed In Table is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name Displayed In Table is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage getBusinessPhoneText2() throws IOException {//uec
		try {
			businessPhone1 = driver.findElement(By.xpath("//input[@id='sys_user.phone']")).getAttribute("value");
			System.out.println("Business Phone Number is " +businessPhone);
			reportStep("Pass", "Business Phone Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Business Phone Text is Not got Successfully" +e);
		}
		return this;
	}
	public void verifyCallerUpdation() throws IOException {//uec
		try {
			if(businessPhone1.equals(modifiedBusinessPhone)) {
				System.out.println("Caller is Updated");
			}
			else {
				System.out.println("Caller is Not Updated");
			}
			reportStep("Pass", "Update Caller is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Update Caller is Not Verified Successfully" +e);
		}
	}
	public CallerPage enterFirstNameOnSearchField2(String fname3) throws IOException {//uec //dec
		 try {
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(fname3,Keys.ENTER);
			reportStep("Pass", "First Name is Entered On Search Field Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Entered On Search Field Successfully" +e);
		}		
		 return this;
	}
	public CallerPage clickOnFirstName2() throws IOException {//uec //dec
		try {
			driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).click();
			reportStep("Pass", "First Name is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Name is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOnDeleteButton() throws IOException {//dec
		try {
			driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[3]")).click();
			reportStep("Pass", "Delete Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public CallerPage clickOndeleteConfirmation() throws IOException {//dec
		try {
			driver.findElement(By.xpath("//button[@class='btn btn-destructive']")).click();
			reportStep("Pass", "Delete Confirmation is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Confirmation is Not Clicked Successfully" +e);
		}
		return this;
	}
	public void verifyCallerDeletion() throws IOException {//dec
		try {
			String displayText = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
			System.out.println(displayText);
			if(displayText.contains("No records to display")) {
				System.out.println("THe Caller is Deleted");
			}
			else {
				System.out.println("THe Caller is Not Deleted");
			}
			reportStep("Pass", "Delete Caller is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Caller is Not Verified Successfully" +e);
		}
	}

}
