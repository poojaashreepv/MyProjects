package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class UpdateExistingIncidentRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="UpdateIncident";

	}
	@BeforeTest
	public void SetData() {
		testName="Update Existing Incident";
		testDescription="Update Existing Incident Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Incident Updation";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void updateIncident(String username,String password,String searchKey,String incNum2) throws IOException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey(searchKey)
		.clickOnIncident().switchToFrame().clickOnNumberInSearchDropdown().enterIncidentNumberInSearchField3(incNum2).clickOnFirstIncidentNumber()
		.updateUrgency().getUrgencyText().updateState().getStateText().clickOnUpdateButton().verifyPriorityState();
	}

}
