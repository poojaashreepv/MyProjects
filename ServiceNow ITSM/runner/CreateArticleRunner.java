package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;


public class CreateArticleRunner extends BaseClass {
	String[][] data;
        @BeforeClass
	public void setfileName() {
		filename="CreateArticle";

	}
	@BeforeTest
	public void SetData() {
		testName="Create Article";
		testDescription="Create Article Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Article Creation";
	}
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void createArticle(String username,String password,String searchKey4,String knowbase,String sdesc) throws IOException, InterruptedException {
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey4(searchKey4)
		.clickOnKnowledge().switchToFrame().clickOnCreateAnArticleButton().getArticleNumberText().enterKnowledgeBase(knowbase)
		.enterShortDescription(sdesc).clickOnSubmitButton();

	}
}
