package runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.LoginPage;

public class DeleteLeadRunner extends BaseClass {
	String[][] data;
	@BeforeClass
	public void setfileName() {
		filename="DeleteLead";

	}
	@BeforeTest
	public void SetData() {
		testName="Delete Lead";
		testDescription="Delete Lead Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Delete Lead";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void deleteLead(String username,String password,String phno) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage1(driver,node);
		lp.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.clickOnCrmsfa().clickOnLeadsButton().clickOnFindLeads().clickOnPhone()
		.enterPhoneNumber(phno).clickOnFindLeads1().getLeadId().clickOnFirstLead2()
                .clickOnDeleteButton().clickOnFindLeads3().enterFirstLeadId2().clickOnFindLeads4()
                .verifyLeadDeletedOrNot();
    	}

}
