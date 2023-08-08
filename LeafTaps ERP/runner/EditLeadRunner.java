package runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.LoginPage;

public class EditLeadRunner extends BaseClass {
	String[][] data;
        @BeforeClass
	public void setfileName() {
		filename="EditLead";

	}
	@BeforeTest
	public void SetData() {
		testName="Edit Lead";
		testDescription="Edit Lead Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Edit Lead";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void editLead(String username,String password,String phno,String cname) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage1(driver,node);
		lp.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.clickOnCrmsfa().clickOnLeadsButton().clickOnFindLeads().clickOnPhone().enterPhoneNumber(phno)
		.clickOnFindLeadsButton().clickOnFirstLead().clickOnEditButton().enterCompanyName(cname)
		.clickOnUpdateButton().verifyEditLeadCompanyName();
	}

}
