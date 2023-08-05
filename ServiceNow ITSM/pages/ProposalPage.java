package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class ProposalPage extends BaseClass {
	Shadow shadow = new Shadow(driver);
	public String number;
	public String proposalNumber;
	List<String> numbersList;
	public int rsize;
	public String stateText;
	public String assignTo;
	public ProposalPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public ProposalPage switchToFrame() throws IOException {//cp //ucp
		try {
			WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(frame1);
			reportStep("Pass", "Frame is Switched Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Frame is Not Switched Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnNewButton() throws IOException {//cp
		 try {
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "New Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "New Button is Not Clicked Successfully" +e);
		}
		 return this;
	}
	public ProposalPage getProposalNumberText() throws IOException {//cp
		try {
			number = driver.findElement(By.xpath("(//input[@type='text'])[1]")).getAttribute("value");
			System.out.println("The Proposal Number is " +number);
			reportStep("Pass", "Proposal Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Proposal Number Text is Not got Successfully" +e);
		}
        return this;
	}
	public ProposalPage enterShortDescription() throws InterruptedException, IOException {//cp
		try {
			driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("ServiceNow",Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Short Description is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Short Description is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnSubmitButton() throws IOException {//cp
		 try {
			driver.findElement(By.xpath("(//button[@class='form_action_button  action_context btn btn-default'])[1]")).click();
			 //Thread.sleep(2000);
			reportStep("Pass", "Submit Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Submit Button is Not Clicked Successfully" +e);
		}
		 return this;
	}
	public ProposalPage getRowSize() throws IOException {//cp
		 try {
			List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr")); 
			int rsize = rowData.size();
			reportStep("Pass", "Row Size is got Successfully");
		 } catch (Exception e) {
			 reportStep("Fail", "Row Size is Not got Successfully" +e);
		}
		 return this;
	}
	public ProposalPage getProposalNumberList() throws IOException {//cp
			 try {
				numbersList=new ArrayList<String>();
				 for(int i=1;i<=rsize;i++) {
				 String numbers = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr["+i+"]/td[3]")).getText();
				 numbersList.add(numbers);
				 }
				 reportStep("Pass", "Proposal Number List is got Successfully");
			} catch (Exception e) {
				reportStep("Fail", "Proposal Number List is Not got Successfully" +e);
			}
		 return this;
		
	}
	public void verifyProposalCreation() throws IOException {//cp
		 try {
			if(numbersList.contains(number)){
				System.out.println("New Proposal " +number+ " is Created");
			 }
			 else {
					System.out.println("New Proposal is Not Created");
			 }
			reportStep("Pass", "Create Proposal is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Create Proposal is Not Verified Successfully" +e);
		}
	}
	public ProposalPage enterProposalNumberInSearchField(String proposalNum) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(proposalNum,Keys.ENTER);//"STDCHG0001038"
			reportStep("Pass", "Proposal Number is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Proposal Number is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnFirstProposalNumberInTable() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr[1]/td[3]/a")).click();
			reportStep("Pass", "First Proposal Number is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Proposal Number is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage getFirstProposalNumberText() throws IOException {//ucp
		try {
			proposalNumber = driver.findElement(By.xpath("(//input[@type='text'])[1]")).getAttribute("value");
			System.out.println("Proposal Number is " +proposalNumber);
			reportStep("Pass", "First Proposal Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "First Proposal Number Text is Not got Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearCategoryField() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
			reportStep("Pass", "Category Field is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Category Field is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterCategory(String category) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(category,Keys.ENTER);
			reportStep("Pass", "Category is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Category is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearAssignmentGroup() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[4]")).clear();
			reportStep("Pass", "Assignment Group is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assignment Group is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterAssignmentGroup(String assgroup) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(assgroup,Keys.ENTER);
			reportStep("Pass", "Assignment Group is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assignment Group is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearAssignTo() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[5]")).clear();
			reportStep("Pass", "Assign To is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assign To is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterAssignTo(String assTo) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[5]")).sendKeys(assTo,Keys.ENTER);
			reportStep("Pass", "Assign To is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assign To is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnInProgressState() throws IOException {//ucp
		try {
			WebElement state = driver.findElement(By.xpath("//select[@class='form-control  ']"));
			Select statedd=new Select(state);
			statedd.selectByVisibleText("In Progress");
			//Thread.sleep(2000);
			reportStep("Pass", "In Progress State is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "In Progress State is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnChangeRequestValues() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//span[@class='tabs2_tab default-focus-outline']")).click();
			reportStep("Pass", "Change Request Values is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Change Request Values is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearShortDescription() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@class='filerTableInput form-control'])[1]")).clear();
			reportStep("Pass", "Short Description is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Short Description is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterShortDescription1(String sdescp) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@class='filerTableInput form-control'])[1]")).sendKeys(sdescp,Keys.ENTER);
			reportStep("Pass", "Short Description is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Short Description is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearAssignmentGroup1() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//input[@class='pull-left form-control filter-reference-input']")).clear();
			reportStep("Pass", "Assignment Group is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assignment Group is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterAssignmentGroup1(String assgroup1) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//input[@class='pull-left form-control filter-reference-input']")).sendKeys(assgroup1,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Assignment Group is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assignment Group is Not Entered Successfully" +e);
		}
	    return this;
	}
	public ProposalPage clearJustification() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[5]")).clear();
			reportStep("Pass", "Justification is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Justification is Not Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterJustification(String jus) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[5]")).sendKeys(jus,Keys.ENTER);
			reportStep("Pass", "Justification is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Justification is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clearRiskAndImpactAnalysis() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[6]")).clear();
			reportStep("Pass", "Risk And Impact Analysis is Cleared Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Risk And Impact Analysis Not is Cleared Successfully" +e);
		}
		return this;
	}
	public ProposalPage enterRiskAndImpactAnalysis(String riskana) throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[6]")).sendKeys(riskana,Keys.ENTER);
			reportStep("Pass", "Risk And Impact Analysis is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Risk And Impact Analysis is Not Entered Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnUpdateButton() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "Update Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Update Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnNumberInSearchDropdown1() throws IOException {//ucp
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
	public ProposalPage enterProposalNumberInSearchField() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(proposalNumber,Keys.ENTER);
			reportStep("Pass", "Proposal Number is Entered In Search Field is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Proposal Number is Entered In Search Field is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage clickOnFirstProposalNumber1() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr[1]/td[3]/a")).click();
			reportStep("Pass", "First Proposal Number is Clicked Successfully");

		} catch (Exception e) {
			reportStep("Fail", "First Proposal Number is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ProposalPage getStateText() throws IOException {//ucp
		try {
			driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr[1]/td[3]/a")).click();
			stateText = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[1]")).getText();
			System.out.println("The State is " +stateText);
			//Thread.sleep(2000);
			reportStep("Pass", "State Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "State Text is Not got Successfully" +e);
		}
		return this;
	}
	public ProposalPage getAssignToText() throws IOException {//ucp
		try {
			assignTo = driver.findElement(By.xpath("//input[@id='sys_display.std_change_proposal.assigned_to']")).getAttribute("value");
			System.out.println("Proposal Is Assign To " +assignTo);
			reportStep("Pass", "Assign To Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Assign To Text is Not got Successfully" +e);
		}
		return this;
	}
	public void verifyStateAndAssignTo() throws IOException {//ucp
		try {
			if((stateText.contains("In Progress")) && (assignTo.contains("Change Manager"))) {
				System.out.println("Proposal State and Assign To is Updated");
			}
			else {
				System.out.println("Proposal State and Assign To is Not Updated");
			}
			reportStep("Pass", "State And Assign To is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "State And Assign To is Not Verified Successfully" +e);
		}
	}
	

}
