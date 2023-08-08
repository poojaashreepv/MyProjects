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

public class CreateAccounts extends BaseClass {
	String[][] data;
        @Test(dataProvider="CreateAccount")
	public void CreateAccounts(String aname) throws InterruptedException {
	    //3. Click on toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    Thread.sleep(2000);
	    //4. Click view All and click Sales from App Launcher
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    Thread.sleep(2000);
	    //5. Click on Accounts tab 
	    WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(accounts).click(accounts).perform();
	    Thread.sleep(2000);
	    //6. Click on New button
	    driver.findElement(By.xpath("//a[@title='New']")).click();
	    //7. Enter 'your name' as account name
	    driver.findElement(By.xpath("(//label[@part='label'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(aname);
	    Thread.sleep(2000);
	    //8. Select Ownership as Public
	    action.sendKeys(Keys.PAGE_DOWN).build().perform();
	    Thread.sleep(2000);
	    WebElement ownership = driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[5]"));
	    action.moveToElement(ownership).perform();
	    Thread.sleep(2000);
	    ownership.click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]")).click();
	    //9. Click save and verify Account name 
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String accountName = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
	    System.out.println("Account Name is " +accountName);
	    if(accountName.contains(aname)) {
	    	System.out.println("Account is created");
	    }
	    else {
	    	System.out.println("Account is not created");
	    }
	}
       @DataProvider(name="CreateAccount")
	public String[][] sendData() {	
		data=new String[2][1];	
        	data[0][0]="Poojaashree";
        	data[1][0]="Sri";
		return data;
		
    }
}