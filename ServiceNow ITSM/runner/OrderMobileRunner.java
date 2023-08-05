package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class OrderMobileRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="OrderMobile";

	}
	
	@BeforeTest
	public void SetData() {
		testName="Order Mobile";
		testDescription="Order Mobile Report";
		testAuthor="TestLeaf";
		testCategory="Smoke Testing";
		testinfo="Order Mobile";
	}
	
	@Test(dataProvider = "fetchData",threadPoolSize = 2)
	public void orderMobile(String username,String password,String searchKey1) throws IOException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey3(searchKey1)
		.clickOnServiceCatalog().switchToFrame().clickOnMobiles().clickOnIphone13().clickOnNoforReplacement()
		.clickUnlimitedMonthlyAllowance().clickOnPinkColor().clickOn128GB().clickOnOrderNow()
		.getOrderPlacedMsgText().verifyOrderPlaced().getTextRequestNumber();

	}
}
