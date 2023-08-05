package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class CreateNewProposalRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="CreateProposal";

	}
	
	@BeforeTest
	public void SetData() {
		testName="Delete Order";
		testDescription="Delete Order Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Order Deletion";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createProposal(String username,String password,String searchKey2) throws IOException, InterruptedException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey2(searchKey2).clickOnProposal().switchToFrame().clickOnNewButton()
		.getProposalNumberText().enterShortDescription().clickOnSubmitButton()
		.getRowSize().getProposalNumberList().verifyProposalCreation();
		

	}
}
