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

public class EditLegalEntity1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="EditLegalEntity")
	public void EditLegalEntity(String lename,String cname,String desc) {
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
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(lename,Keys.ENTER);
	    //Thread.sleep(2000);
	    //7. Click on the Dropdown icon and Select Edit
	    WebElement optiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]/span/div/a"));
	    action.moveToElement(optiondd).perform();
        //Thread.sleep(2000);
        optiondd.click();
        //Thread.sleep(2000);
        WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
        action.moveToElement(edit).perform();
        //Thread.sleep(2000);
        edit.click();
        //Thread.sleep(2000);
        //8.Enter the Company name
        driver.findElement(By.xpath("//label[text()='Company Name']")).click();
        driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(cname,Keys.ENTER);
        //9. Enter Description
        driver.findElement(By.xpath("//label[text()='Description']")).click();
        driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(desc,Keys.ENTER);
        //10.Select Status as 'Active'
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        //Thread.sleep(2000);
        WebElement status = driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
        action.moveToElement(status).perform();
	    //Thread.sleep(2000);
	    status.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@title='Active']")).click();
	    //11. Click on Save and Verify Status as Active
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@title='Salesforce Automation by Poojaashree'])[1]")).click();
	    String status1 = driver.findElement(By.xpath("( //lightning-formatted-text[@slot='outputField'])[4]")).getText();
	    System.out.println("The Status is " +status1 );
	    if(status1.contains("Active")) {
	    	System.out.println("The Status is Active");
	    }
	    else {
	    	System.out.println("The Status is Not Active");
	    }
	    
	}
	@DataProvider(name="EditLegalEntity")
	public String[][] sendData() {	
		data=new String[2][3];
		data[0][0]="Salesforce Automation by Poojaashree";
		data[0][1]="Testleaf";
		data[0][2]="SalesForce";
        data[1][0]="Automation by Poojaashree";
        data[1][1]="Testleaf";
        data[1][2]="Software Testing";
        return data;	
    }

}
