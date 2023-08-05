package runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.LoginPage;

public class MergeLeadRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="MergeLead";

	}
	@BeforeTest
	public void SetData() {
		testName="Merge Lead";
		testDescription="Merge Lead Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Merge Lead";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void mergeLead(String username,String password,String fname,String fname1) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage1(driver,node);
		lp.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.clickOnCrmsfa().clickOnLeadsButton().clickOnMergeLeads().cickOnFromLeadWidget()
		.enterFirstName(fname).clickOnFindLeadsButton1().getFirstLeadIdText().clickOnFirstLeadId()
		.cickOnToLeadWidget().enterFirstName1(fname1).clickOnFindLeadsButton1().clickOnFirstLeadId()
		.clickOnMerge()./*acceptAlert().*/clickOnFindLeads3().enterLeadId().clickOnFindLeadsButton2().verifyLeadPresentOrNot();

    }

}
