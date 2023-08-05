package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class CreateNewIncidentRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="CreateIncident";

	}
	@BeforeTest
	public void SetData() {
		testName="Create Incident";
		testDescription="Create Incident Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Incident Creation";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createIncident(String username,String password,String searchKey,String descp) throws IOException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().clickOnAll()
		.searchOnKey(searchKey).clickOnIncident().switchToFrame().clickOnNewButton().getIncidentNumber()
		.enterDescription(descp).clickOnSubmitButton().clickOnNumberInSearchDropdown().enterIncidentNumberInSearchField()
		.getFirstIncidentNumber().verifyNewIncident();
		
		
	}
	

}
