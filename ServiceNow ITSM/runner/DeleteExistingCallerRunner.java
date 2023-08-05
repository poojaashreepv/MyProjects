package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class DeleteExistingCallerRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="DeleteCaller";

	}
	@BeforeTest
	public void SetData() {
		testName="Delete Caller";
		testDescription="Delete Caller Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Caller Deletion";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void deleteCaller(String username,String password,String searchKey4,String fname3) throws IOException, InterruptedException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey(searchKey4).clickOnCaller().switchToFrame().enterFirstNameOnSearchField2(fname3)
		.clickOnFirstName2().clickOnDeleteButton().clickOndeleteConfirmation().verifyCallerDeletion();
		
	}

}
