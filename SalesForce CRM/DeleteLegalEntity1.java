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

public class DeleteLegalEntity1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteLegalEntity")
	public void DeleteLegalEntity(String lename) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions action=new Actions(driver);
		action.moveToElement(legalEntities).click(legalEntities).perform();
	    //Thread.sleep(2000);
	    //5. Click on the legal Entities tab 
	    driver.navigate().refresh();
	    WebElement legalEntitiesTab = driver.findElement(By.xpath("//a[@title='Legal Entities']"));
	    action.moveToElement(legalEntitiesTab).click(legalEntitiesTab).perform();
	    //6. Search the Legal Entity
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
	    search.sendKeys(lename,Keys.ENTER);
	    //Thread.sleep(2000);
	    //7. Click on the Dropdown icon and Select Delete
	    WebElement optiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]/span/div/a"));
	    action.moveToElement(optiondd).perform();
        //Thread.sleep(2000);
        optiondd.click();
        //Thread.sleep(2000);
        WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
        action.moveToElement(delete).perform();
        //Thread.sleep(2000);
        delete.click();
        //Thread.sleep(2000);
        //8.Click on the Delete option in the displayed popup window.
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //9. Verify Whether Legal Entity is Deleted using Legal Entity Name
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
	    search.sendKeys(lename,Keys.ENTER);
	    String text2 = driver.findElement(By.xpath("//div[@class='emptyContent slds-is-absolute']")).getText();
	    if(text2.equals("No items to display.")) {
	    	System.out.println("Legal Entity is Deleted");
	    	
	    }
	    else {
	    	System.out.println("Legal Entity is Not Deleted");
	    }
        
	}
	@DataProvider(name="DeleteLegalEntity")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Salesforce Automation by Poojaashree";
        data[1][0]="Automation by Poojaashree";
        return data;	
    }

}
