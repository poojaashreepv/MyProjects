package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class CreateNewCallerRunner extends BaseClass {
	String[][] data;
        @BeforeClass
	public void setfileName() {
		filename="CreateCaller";

	}
	@BeforeTest
	public void SetData() {
		testName="Create Caller";
		testDescription="Create Caller Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Caller Creation";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createCaller(String username,String password,String searchKey3,String fname,String lname,String title,String email,String bphoneno,String mphoneno,String fname1) throws IOException, InterruptedException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey3(searchKey3).clickOnCaller().switchToFrame().clickOnNewButton().enterFirstName(fname)
		.enterLastName(lname).enterTitle(title).enterEmail(email).ebterBusinessPhone(bphoneno)
		.enterMobilePhone(mphoneno).clickOnSubmitButton().enterFirstNameOnSearchField(fname1)
		.clickOnFirstName().getFirstNameText().getLastNameText().getTitleText()
		.getEmailText().getBusinessPhoneText().getMobilePhoneText().verifyCallerCreation();

        }
}
