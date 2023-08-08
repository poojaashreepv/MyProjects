package salesforce;

import java.nio.file.ReadOnlyFileSystemException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewOpportunity extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateNewOpportunity")
	public void CreateNewOpportunity(String oname) throws InterruptedException {
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
	        //6. Click on New button
        	driver.findElement(By.xpath("//div[@title='New']")).click();
        	//7. Enter Opportunity name Get the text and Store it
        	driver.findElement(By.xpath("(//label[@class='slds-form-element__label slds-no-flex'])[2]")).click();
        	driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(oname);
        	Thread.sleep(2000);
        	//8. Choose close date as Today
        	driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-align_absolute-center')]")).click();
        	Thread.sleep(2000);
        	//9. Select 'Stage' as Need Analysis
        	driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("(//span[text()='Needs Analysis'])[2]")).click();
        	Thread.sleep(2000);
        	//10. click Save and VerifyOppurtunity Name
        	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        	String text = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
        	System.out.println(text);
        	if(text.contains(oname)){
        	     System.out.println("Opportunity is created");
        	}
        	else {
        	     System.out.println("Opportunity is not created");
        	}
        
        }
	@DataProvider(name="CreateNewOpportunity")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Salesforce Automation by Poojaashree";
        	data[1][0]="Automation by Poojaashree";
        	return data;	
    }

}
