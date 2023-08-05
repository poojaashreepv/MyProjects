package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class UpdateChangeProposalRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="UpdateProposal";

	}
	@BeforeTest
	public void SetData() {
		testName="Update Proposal";
		testDescription="Update Proposal Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Proposal Updation";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void updateProposal(String username,String password,String searchKey2,String proposalNum,String category,String assgroup,String assTo,String sdescp,String assgroup1,String jus,String riskana) throws IOException, InterruptedException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey2(searchKey2).clickOnProposal().switchToFrame().enterProposalNumberInSearchField(proposalNum)
		.clickOnFirstProposalNumberInTable().getFirstProposalNumberText().clearCategoryField()
		.enterCategory(category).clearAssignmentGroup().enterAssignmentGroup(assgroup).clearAssignTo().enterAssignTo(assTo)
		.clickOnInProgressState().clickOnChangeRequestValues().clearShortDescription().enterShortDescription1(sdescp)
		.clearAssignmentGroup1().enterAssignmentGroup1(assgroup1).clearJustification().enterJustification(jus)
		.clearRiskAndImpactAnalysis().enterRiskAndImpactAnalysis(riskana).clickOnUpdateButton()
		.clickOnNumberInSearchDropdown1().enterProposalNumberInSearchField().clickOnFirstProposalNumber1()
		.getStateText().getAssignToText().verifyStateAndAssignTo();
		

}
}
