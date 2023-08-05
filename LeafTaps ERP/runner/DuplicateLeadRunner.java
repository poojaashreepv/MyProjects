package runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.LoginPage;

public class DuplicateLeadRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="DuplicateLead";

	}
	@BeforeTest
	public void SetData() {
		testName="Duplicate Lead";
		testDescription="Duplicate Lead Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Duplicate Lead";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void duplicateLead(String username,String password,String phno) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage1(driver,node);
		lp.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.clickOnCrmsfa().clickOnLeadsButton().clickOnFindLeads().clickOnPhone().enterPhoneNumber(phno)
		.clickOnFindLeadsButton().clickOnFirstLead1().clickOnDuplicateLead().clickOnCreateLeadButton().verifyDuplicateLeadPhoneNumber();
	}

}
