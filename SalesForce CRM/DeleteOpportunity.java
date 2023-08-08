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

public class DeleteOpportunity extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteOpportunity") 
	public void DeleteOpportunity(String oname) throws InterruptedException {
	    //3. Click on toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4. Click view All and click Sales from App Launcher
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    Thread.sleep(2000);
	    //5. Click on Opportunity tab 
	    WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(opportunity).click(opportunity).perform();
	    Thread.sleep(2000);
	    //6. Search the Opportunity
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
	    search.sendKeys(oname,Keys.ENTER);
	    //Thread.sleep(2000);
	    //7. Click on  the Dropdown icon and Select Delete
	    driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/span/div/a/span")).click();
	    WebElement delete = driver.findElement(By.xpath("//div[text()='Delete']"));
	    driver.executeScript("arguments[0].click();", delete);
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
	    //8. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
            driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
	    search.sendKeys(oname,Keys.ENTER);
	    String text2 = driver.findElement(By.xpath("//div[@class='emptyContent slds-is-absolute']")).getText();
	    if(text2.equals("No items to display.")) {
	    	System.out.println("Opportunity is Deleted");
	    	
	    }
	    else {
	    	System.out.println("Opportunity is Not Deleted");
	    }
        
	}
	@DataProvider(name="DeleteOpportunity")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Salesforce Automation by Poojaashree";
        	data[1][0]="Automation by Poojaashree";
        	return data;	
    }

}
