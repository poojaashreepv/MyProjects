package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class DeleteIncidentRunner extends BaseClass {
	String[][] data;
        @BeforeClass
	public void setfileName() {
		filename="DeleteIncident";

	}
	@BeforeTest
	public void SetData() {
		testName="Delete Incident";
		testDescription="Delete Incident Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Incident Deletion";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void deleteIncident(String username,String password,String searchKey,String incNum1) throws IOException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey(searchKey)
		.clickOnIncident().switchToFrame().clickOnNumberInSearchDropdown().enterIncidentNumberInSearchField2(incNum1)
		.getFirstIncidentNumber().clickOnFirstIncidentNumber().getIncidentNumber1().clickOnDeleteButton()
		.clickOnDeleteConfirmationButton().verifyDeleteIncident();
	}

}
