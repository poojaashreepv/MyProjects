package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class UpdateExistingCallerRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="UpdateCaller";

	}
	@BeforeTest
	public void SetData() {
		testName="Update Caller";
		testDescription="Update Caller Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Caller Updation";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void updateCaller(String username,String password,String searchKey4,String fname2,String bphoneno1) throws IOException, InterruptedException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey(searchKey4).clickOnCaller().switchToFrame().enterFirstNameOnSearchField1(fname2)
		.clickOnFirstName1().clearBusinessPhone().enterBusinessPhone(bphoneno1)
		.getBusinessPhoneText1().clickOnUpdateButton().clickOnFirstNameDisplayedInTable()
		.getBusinessPhoneText2().verifyCallerUpdation();
	}
}
