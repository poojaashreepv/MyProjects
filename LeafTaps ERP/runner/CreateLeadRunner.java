package runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.LoginPage;

public class CreateLeadRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="CreateLead";

	}
	@BeforeTest
	public void SetData() {
		testName="Create Lead";
		testDescription="Create Lead Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Create Lead";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createLead(String username,String password,String cname,String fname,String lname,String phno) throws IOException
	{
		LoginPage lp=new LoginPage1(driver,node);
		lp.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.clickOnCrmsfa().clickOnLeadsButton().clickOnCreateLead().enterCompanyName(cname)
		.enterFirstName(fname).enterLastName(lname).enterPhoneNumber(phno)
		.clickOnCreateLeadButton().verifyCreatedLeadFirstName();
		
	}

}
