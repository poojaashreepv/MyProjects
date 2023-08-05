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

public class CreateLegalEntity1 extends BaseClass {
    String[][] data;
	@Test(dataProvider="CreateLegalEntity")
	public void CreateLegalEntity(String name) {
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//3. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions action=new Actions(driver);
		action.moveToElement(legalEntities).click(legalEntities).perform();
	    //Thread.sleep(2000);
	    //4. Click on the Dropdown icon in the legal Entities tab
	    WebElement legalEntitiesdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
	    action.moveToElement(legalEntitiesdd).click(legalEntitiesdd).perform();
	    //Thread.sleep(2000);
	    //5. Click on New Legal Entity
	    WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
	    action.moveToElement(newLegalEntity).click(newLegalEntity).perform();
	    //Thread.sleep(2000);
	    //6. Enter Name 
	    driver.findElement(By.xpath("(//label[@class='slds-form-element__label slds-no-flex'])[1]")).click();
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(name,Keys.ENTER);
	    //7.Click save and verify Legal Entity Name
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    String legalEntityName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	    System.out.println("Legal Entity Name is " +legalEntityName);
	    if(legalEntityName.contains(name)) {
	    	System.out.println("Leagal Entity is created");
	    }
	    else {
	    	System.out.println("Legal Entity is not created");
	    }
	   
	    
	}
	@DataProvider(name="CreateLegalEntity")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Salesforce Automation by Poojaashree";
        data[1][0]="Automation by Poojaashree";
        return data;	
    }

}
