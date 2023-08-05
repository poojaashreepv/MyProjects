package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;


public class CreateArticleFillMandatoryFieldsRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="CreateArticleFillMandatoryFields";

	}
	@BeforeTest
	public void SetData() {
		testName="Create Article";
		testDescription="Create Article Report";
		testAuthor="TestLeaf";
		testCategory="Sanity Testing";
		testinfo="Article Creation";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createArticleFillMandatoryFields(String username,String password,String searchKey4,String knowbase,String categ,String sdesc1) throws IOException, InterruptedException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton()
		.searchOnKey4(searchKey4).clickOnKnowledge().switchToFrame().clickOnCreateAnArticleButton()
		.getArticleNumberText().enterKnowledgeBase(knowbase).enterCategory(categ)
		.enterShortDescription1(sdesc1).clickOnSubmitButton();
		
	}

}
