package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
    
public class VerifyTheMandatoryFieldAlertMsgForWorkType1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="VerifyTheMandatoryFieldAlertMsgForWorkType")
	public void VerifyTheMandatoryFieldAlertMsgForWorkType(String worktypename) {
		//3) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//5) Click on Work Types
		WebElement workTypes = driver.findElement(By.xpath("//p[text()='Work Types']"));
		Actions action=new Actions(driver);
		action.moveToElement(workTypes).click(workTypes).perform();
	    //Thread.sleep(2000);
	    //6) Click on New
	    driver.findElement(By.xpath("//div[@title='New']")).click();
	    //7) Enter Work Type Name
	    driver.findElement(By.xpath("(//span[text()='Work Type Name'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(worktypename,Keys.ENTER);
	    //8) Click on Save
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    String genericNotification = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
	    System.out.println("The Generic Notification displayed on the page is " +genericNotification);
	    String alertMsg = driver.findElement(By.xpath("//ul[@class='errorsList']")).getText();
	    System.out.println("The Alert Message displayed on the page is " +alertMsg);
	    if(alertMsg.contains("Estimated Duration")) {
	    	System.out.println("The Alert Message is displayed for Estimated Duration");
	    }
	    else {
	    	System.out.println("The Alert Message is not displayed for Estimated Duration");
	    }

	}
	@DataProvider(name="VerifyTheMandatoryFieldAlertMsgForWorkType")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Bootcamp";
		data[1][0]="Salesforce Project";

}
