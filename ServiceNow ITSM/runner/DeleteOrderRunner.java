package runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.LoginPage;

public class DeleteOrderRunner extends BaseClass {
	String[][] data;

	@BeforeClass
	public void setfileName() {
		filename="DeleteOrder";

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
	public void deleteOrder(String username,String password,String searchKey2) throws IOException {
		
		LoginPage lps=new LoginPage(driver, node);
		lps.enterUserName(username).enterPassword(password).clickOnLoginButton().searchOnKey(searchKey2)
		.clickOnServiceCatalog().switchToFrame().clickOnMobiles().clickOnIphone13().clickOnNoforReplacement()
		.clickUnlimitedMonthlyAllowance().clickOnPinkColor().clickOn128GB().clickOnOrderNow()
		.getOrderPlacedMsgText().getTextRequestNumber1().clickOnDisplayedReqestNumber().clickOnDeleteButton()
		.clickOnDeleteConfirmation().getOrderStatus().verifyOrderDeleted();

}
}
