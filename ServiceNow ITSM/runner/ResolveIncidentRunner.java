package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class ResolveIncidentRunner extends BaseClass {
	String[][] data;
	@BeforeClass
	public void setfileName() {
		filename="ResolveIncident";

	}
	@BeforeTest
	public void SetData() {
		testName="Resolve Incident";
		testDescription="Resolve Incident Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Incident Updation";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void resolveIncident(String username,String password,String searchKey,String incNum) throws IOException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey(searchKey)
		.clickOnIncident().switchToFrame().clickOnNumberInSearchDropdown().enterIncidentNumberInSearchField1(incNum)
		.clickOnFirstIncidentNumber().updateState1().getStateText().clickOnUpdateButton().verifyState();
	}

}

